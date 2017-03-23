import functools as ft

# oh god, 40 is "forty" and not "fourty" :((((
nty = ["empty", "empty", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"]
dgt = ["empty", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"]
teen = ["ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"]

def number_to_string(n):
    if(n == 1000):
        return "onethousand"

    if(n >= 100):
        if(n % 100 == 0):
            return number_to_string(int(n/100)) + "hundred"
        else:
            return number_to_string(int(n/100)) + "hundredand" + number_to_string(n % 100)
    elif(n >= 20):
        if(n % 10 == 0):
            return nty[int(n/10)]
        else:
            return nty[int(n/10)] + dgt[n % 10]
    elif(n >= 10):
        return teen[n%10]
    else:
        return dgt[n]

def euler_17_solution():
    numberstring = ft.reduce(lambda a,b: a+""+b, list([number_to_string(i) for i in range(1, 1001)]))
#    print(numberstring)
    return len(numberstring)
    
def main():
    print(euler_17_solution())

main()

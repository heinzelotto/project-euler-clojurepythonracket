def memoize(f):
    memo = {}
    def helper(x):
        if x not in memo:            
            memo[x] = f(x)
        return memo[x]
    return helper

@memoize
def collatz(k):
    #print("{}\n".format(k))
    if (k == 1):
        return 1
    elif (k % 2 == 1):
        return 1+collatz(3*k+1)
    else:
        return 1+collatz(k/2)

def euler_14_solution():
    argmax = 1
    for i in range(333332,1000000):
        if(collatz(i) > collatz(argmax)):
            argmax = i

    return argmax

def main():
    print(euler_14_solution())
    
main()

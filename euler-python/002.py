def even(x):
    if (x % 2 == 0):
        return True
    else:
        return False

def fibonacci_solution(n):
    fibonacci_alt = 1
    fibonacci_aktuell = 2    
    fibonacci_neu = fibonacci_alt + fibonacci_aktuell

    sum = 0 + 2

    while(fibonacci_neu < n):
        fibonacci_alt = fibonacci_aktuell
        fibonacci_aktuell = fibonacci_neu
        fibonacci_neu = fibonacci_alt + fibonacci_aktuell

        if (even(fibonacci_aktuell)):
            sum += fibonacci_aktuell
    
    return sum

def main():
    print(fibonacci_solution(4000000))

main()

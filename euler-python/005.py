import functools

def gcd(m, n):
    if (m < n):
        return gcd(n, m)
    elif (m == 1):
        return 1
    elif (n == 0):
        return m
    else:
        return gcd(n, m % n)

def lcm(m, n):
    return m*n/gcd(m,n)

def euler5_solution():
    return functools.reduce(lcm, range(1,101))

def main():
    print (euler5_solution())

main()

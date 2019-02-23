import math

def factor(n):
    while (n % 2 == 0):
        print(2, end=" ")
        n = n/2
    for i in range(3, math.ceil(math.sqrt(n)), 2):
        while (n % i == 0):
            print(i, end=" ")
            n = n/i
    if (n > 2):
        print(int(n), end=" ")

user = input("Enter number to factor: ")
n = int(user)
print("Prime Factorization of", n, "is:")
factor(n)

def fact(n):
    if (n == 1):
        return 1
    return n * fact(n - 1)

user = int(input("Enter number:"))
print(str(fact(user)))

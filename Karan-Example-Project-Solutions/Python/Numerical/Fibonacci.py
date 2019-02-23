def fibonacci(n):
    if (n <= 1):
        return n
    return fibonacci(n-1) + fibonacci(n-2)

user = input("Enter number of terms: ")
n = int(user)
print("The Fibonacci Sequence up to", n, "terms is:")
for i in range(0, n):
    print(fibonacci(i), end=" ")

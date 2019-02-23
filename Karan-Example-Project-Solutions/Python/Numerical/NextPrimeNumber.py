import math

def isPrime(n):
    for i in range(2, math.ceil(n/2)):
        remain = n % i
        if (remain == 0):
            return False
    return True

user = input("Find prime? y/n: ")
if (user == 'y'):
    state = True
else:
    state = False

count = 2
while (state):
    if (isPrime(int(count))):
        print("Next prime is", count, end="")
        user = input(". Find another prime? y/n: ")
        if (user == 'n'):
            state = False
    count = count + 1

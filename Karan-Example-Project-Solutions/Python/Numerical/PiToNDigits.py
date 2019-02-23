import math

def piToNDigits(n):
    if (n == 0):
        return 0
    return float(str(math.pi)[0:n+1])

user = input("How many digits? ")
n = int(user)
if (n > 21):
    print("math.pi is only accurate up to 21 digits")
    exit()
print("Pi to", n, "digits is", piToNDigits(n))


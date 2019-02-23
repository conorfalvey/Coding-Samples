import math

def eToNDigits(n):
    if (n == 0):
        return 0
    return float(str(math.e)[0:n+1])

user = input("How many digits? ")
n = int(user)
if (n > 21):
    print("math.e is only accurate up to 21 digits")
    exit()
print("E to", n, "digits is", eToNDigits(n))

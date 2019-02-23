import math

def isBinary(n):
    while (n > 1) :
        if (n % 10 > 1):
            return False
        n = n / 10
    return True

def binaryToDecimal(n):
    result = 0
    count = 0
    while (n > 0):
        if (n % 10 == 1):
            result += 2 ** count
        count = count + 1
        n = n / 10
    return result

def decimalToBinary(n):
    elements = list()
    out = 0
    while (n > 0):
        elements.append(n % 2)
        n = int(n / 2)
        
    for i in range(len(elements)):
        out = out + (10 ** i) * elements[i]
    return out


user = int(input("Enter number to convert: "))

if (isBinary(user)):
    print("Binary number", user, "in decimal is", binaryToDecimal(user))
else:
    print("Decimal number", user, "in binary is", decimalToBinary(user))

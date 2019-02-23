import math

def change(n):
    total = str(math.floor(n * 100)/100)
    n = int(n * 100)
    quarters = 0
    dimes = 0
    nickels = 0
    pennies = 0

    while (n >= 5):
        if (n - 25 >= 0):
            quarters = quarters + 1
            n = n - 25
        elif (n - 10 >= 0):
            dimes = dimes + 1
            n = n - 10
        elif (n - 5 >= 0):
            nickels = nickels + 1
            n = n - 5
    pennies = n
    print(str(quarters), "Quarters,", str(dimes), "Dimes,",
          str(nickels), "Nickels,", str(pennies), "Pennies. Total:", total)

cost = float(input("What is the cost of the item: "))
given = float(input("What is the amount paid with: "))

if (cost > given):
    print("Not enough money given!")
elif (cost == given):
    print("Exact change given!")
else:
    change(given - cost)

def calc(interest, months, principal):
    if (interest == 0):
        print(principal/months)
    else:
        print((interest * principal * (1 + interest) ** months)/((1 + interest) ** months + 1))

interest = float(input("Please enter the interest rate: "))
months = int(input("Please enter the loan's term in months: "))
principal = float(input("Please enter the amount initially borrowed: "))

print("Monthy payment of $" + str(principal) + " loan over "
        + str(months) + " months at " + str((interest * 100)) + "% is ", end="")
calc(interest, months, principal)

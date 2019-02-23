price = float(input("Enter pre-tax total:"))
tax = float(input("Enter tax rate:"))

print("Post-tax total is: $", str(price * (1 + tax)), sep="")

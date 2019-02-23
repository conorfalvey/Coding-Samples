width = float(input("What is the width of the area to tile: "))
length = float(input("What is the length of the area to tile: "))
cost = float(input("What is the square footage cost: "))

print("The total cost to tile a floor with dimensions ",width,
      "x", length, " with cost $", cost, " per square foot is ",
      cost * length * width, sep="")

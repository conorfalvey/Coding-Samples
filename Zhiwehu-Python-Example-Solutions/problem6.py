import math

def root(num):
    c = 50
    h = 30
    return math.sqrt((2 * c * num)/h)

inputLine = raw_input("Please enter numbers seperated by commas: ")
list = inputLine.split(',')
list = map(int, list)
for i in range(len(list)):
    list[i] = root(list[i])
list = map(int, list)

print(', '.join(str(x) for x in list))

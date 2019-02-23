list = raw_input("Enter dimensions: ").split(',')

array = [[0 for x in range(int(list[1]))] for y in range(int(list[0]))]

for x in range(len(array)):
    for y in range(len(array[x])):
        array[x][y] = x * y

print(array)

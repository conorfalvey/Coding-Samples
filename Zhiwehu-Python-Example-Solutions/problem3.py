number = input("Input Upper Limit: ")
dictionary = {}

for i in range(1, int(number) + 1):
    dictionary[i] = i * i

print(dictionary)

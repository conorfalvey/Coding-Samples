user = input("Enter phrase to encrypt:")
offset = input("Enter the offset:")

result = ""
for i in range(len(user)):
    char = user[i]
    if (char.isupper()):
        result += chr((ord(char) + int(offset) - 65) % 26 + 65)
    elif (char.islower()):
        result += chr((ord(char) + int(offset) - 97) % 26 + 97)
    
print(result)

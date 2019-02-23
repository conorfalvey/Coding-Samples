import string

def convert(string):
    if string[0] in "aeiou":
        return string + 'yay'
    else:
        return string[1:] + string[0] + 'ay'

user = str(input("Enter sentence to convert: "))
user = user.translate(str.maketrans('', '', string.punctuation))
user = user.translate(str.maketrans('', '', '1234567890'))
ls= user.split(" ")

print(' '.join(convert(elem) for elem in ls))

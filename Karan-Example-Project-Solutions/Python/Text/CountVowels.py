user = input("Enter word or sentence to check vowels:")
count = 0
for i in user:
    if (i in 'aeiouAEIOU'):
        count = count + 1
print(count)

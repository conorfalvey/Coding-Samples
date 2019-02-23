def collatz(n):
    count = 0
    
    while (n != 1):
        if (n % 2 == 0):
            n = n / 2
        else:
            n = n * 3 + 1
        count = count + 1

    return count

n = int(input("Choose number to analyze with Collatz Conjecture: "))
while (n < 2):
    n = int(input("Must start with number greater than 1! New number: "))
            
print("Collatz Conjecture took", collatz(n), "steps to reach 1.")

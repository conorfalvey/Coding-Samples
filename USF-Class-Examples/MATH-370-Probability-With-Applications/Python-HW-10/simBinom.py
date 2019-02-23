import numpy as np
import matplotlib.pyplot as plt

N = 20
p = .25

numExperiments = 10000
results = np.zeros(numExperiments)

for idx in range(numExperiments):
    
    numSuccesses = 0
    for i in range(N):
        
        x = np.random.rand()
        if x < p:
            numSuccesses += 1
            
    results[idx] = numSuccesses

unique, counts = np.unique(results, return_counts=True)
freqs = np.double(counts)/numExperiments

total = sum(results) / numExperiments
print("Expected with N = " + str(N) + ", p = " + str(p) + ": " + str(N * p))
print("Actual: " + str(total))

plt.figure()
plt.bar(unique,freqs,align = 'center')
#plt.title("Binomial Distribution")
#plt.xlabel("Trials")
#plt.ylabel("Probability")
#plt.xticks(range(N))
plt.savefig("bar.png")
plt.show()


    







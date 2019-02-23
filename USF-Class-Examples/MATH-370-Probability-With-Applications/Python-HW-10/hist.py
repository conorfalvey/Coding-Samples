import numpy as np
import matplotlib.pyplot as plt

success_prob = .25

numExperiments = 10000
results = np.zeros(numExperiments)
sums = np.zeros(numExperiments)

for idx in range(numExperiments):
    noHeads = True
    count = 0
    while(noHeads):
        x = np.random.rand()
        if x < success_prob:
            count = count + 1
        else:
            noHeads = False
    results[idx] = count

print("Expected with p = " + str(success_prob) + ": " + str(success_prob/(1 - success_prob)))
total = sum(results) / float(numExperiments)
print("Actual: " + str(total))
plt.figure()
#Display breaks on large values of success_prob as the range of the histogram
#sums the values out of the range, and the last bin is overrepresented.
#To fix when testing:
#histogram range upper limit = success_prob * 20
#histogram bins = success_prob * 20
#xtick range = success_prob * 20 + 1
#Could be fixed by dynamically assigning the values on running,
#but I've already completed the data collection
plt.hist(results, bins=5, range=(0, 5))
plt.title("Biased Coin Toss until Heads: Success Chance = " + str(success_prob))
plt.xlabel("Trials until heads")
plt.xticks(range(6))
plt.ylabel("Frequency")
plt.savefig("histogram.png")
plt.show()

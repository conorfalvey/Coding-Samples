import numpy as np
import matplotlib.pyplot as plt

n = 20
p = .25
numExperiments = 10000
Yvals = np.zeros(numExperiments)

def flipUntilHeads(p):
    success = False
    numTosses = 0
    while(success == False):
        x = np.random.rand()
        numTosses += 1
        if x < p:
            success = True
    return numTosses

for idx in range(numExperiments):
    Y = 0
    for i in range(n):
        Y = Y + flipUntilHeads(p)
    Y = Y/n
    Yvals[idx] = Y

plt.figure()
plt.hist(Yvals, bins='auto')
plt.title("Distribution via Central Limit Theorem")
plt.ylabel("Occurances")
plt.xlabel("Yval number")
plt.savefig("normal.png")
plt.show()

mu = 1/p
sigma = np.sqrt((1-p)/(n*p**2))

c = np.sqrt(2 * np.pi)*sigma
x = np.linspace(np.min(Yvals),np.max(Yvals),200)
y = (1/c) * np.exp(-.5*(x - mu)**2/sigma**2)

plt.figure()
plt.plot(x,y)
plt.savefig("normal2.png")
plt.show()

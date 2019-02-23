import random
import math

def sort(nums):
    if (len(nums) > 1):
        mid = math.floor(len(nums) / 2)
        low = nums[:mid]
        high = nums[mid:]

        sort(low)
        sort(high)

        i = 0
        j = 0
        k = 0
        
        while (i < len(low) and j < len(high)):
            if low[i] < high[j]:
                nums[k] = low[i]
                i = i + 1
            else:
                nums[k] = high[j]
                j = j + 1
            k = k + 1

        while (i < len(low)):
            nums[k] = low[i]
            i = i + 1
            k = k + 1

        while (j < len(high)):
            nums[k] = high[j]
            j = j + 1
            k = k + 1

nums = random.sample(range(0, 10000), 100)
print("Before sort:", nums)
sort(nums)
print("After sort:", nums)

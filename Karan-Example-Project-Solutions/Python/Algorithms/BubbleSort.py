import random

def sort(nums):
    for i in range(len(nums) - 1):
        for j in range(len(nums) - i - 1):
            if (nums[j] > nums[j + 1]):
                swap(nums, j, j + 1)

def swap(nums, indexOne, indexTwo):
    temp = nums[indexOne]
    nums[indexOne] = nums[indexTwo]
    nums[indexTwo] = temp

nums = random.sample(range(0, 10000), 100)
print("Before sort:", nums)
sort(nums)
print("After sort:", nums)

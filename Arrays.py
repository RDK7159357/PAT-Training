# Traversal
a=[10,20,30,40,50]
# for i in a:
#     print(i) # O(n)
   

# Insertion
a.append(50) # best case O(1)

a.insert(2,5) # Worst case O(n)


# Deletion
a.pop() # best case : deleeting the last element 

a.pop(1) # worst case O(n) : deleting the first element and shifting takes place

# Searching

# if 30 in a:
    # print("Found") # O(n) linear search 
    # O(logn) Binary search

# Updation
a[2]=25 # O(1) due to direct access

# Sorting

b = [20,10,30,50,40]
b.sort()
sorted(b) # O(nlogn)
# sort and sorted use TimSort : O(nlogn) base 2 (Combination of merge sort and quick sort)
# best case O(n) 
# worst sort/ Avg case : O(nlogn)


# Merging : Combining 2 sorted arr into a single sorted arr is called merging

res = sorted(a+b) # O(nlogn)


# Splitting

first_half, second_half = a[:len(a)//2], a[len(a)//2:] # Single split O(n)
# print(first_half)
# print(second_half)


# Or

mid = len(a)//2 # finding mid ele takes O(1)
first_half = a[:mid] # Creating two subarrays O(n)

second_half = a[mid:] # space complexity O(n)
# print(first_half)
# print(second_half)

# Splitting Special Case - Logical Split O(1)

first1_half = (0,mid)
second1_half = (mid,len(a))
# print(first1_half)
# print(second1_half)

# ---------------------------------------

# Reversing
a.reverse() # two pointer approach and In Place : O(n)


left,right = 0,len(a) - 1


arr = [10,20,30,40,50]

while(left<right):
    (arr[left],arr[right]) = (arr[right],arr[left]) # O(n)
    left+=1

    right-=1
# print(arr)


# Reversing an array with slicing 
arr= arr[::-1] # Time complexity O(n)
# Space Complexity O(n)


# ---------------------------

# Prefix Sum

a1 = [10,20,30,40] # prefix sum = [0,10,30,60,100]

prefix_sum = [0] * (len(a1) +1) # prefix sum = [0,0,0,0,0] Time complexity : O(n) 
                                                            # Space complexity : O(n)

for i in range(len(a1)):

    prefix_sum[i+1] = prefix_sum[i] + a1[i]  

# print(prefix_sum)


# Optimized Prefix Sum

for i in range(1,len(a1)):
    a1[i] = a1[i] + a1[i-1]


#----------------------------------

# Sliding Window Technique

# Max Subarray Sum

a2 = [2,3,4,1,5]
k=3

max_sum = sum(a[:k]) # initial window sum

for i in range(len(a) - k): # i -> 0,1
    max_sum = max_sum - a2[i] + a2[i+k]
# print(max_sum)


# Two Pointer

a3 = [1,2,3,4,5]

left1 = 0
right1 = len(a3) -1
target =6
while(left1<right1):
    sum = a3[left1] +a3[right1]
    if(sum==target):
        # print(a3[left1],a3[right1])
        break
    else:
        left1+=1
        right1-=1


#-------------------


# Simulation program for Sorted method without built in function
a4 = [10,20,30]
a5 = [15,25,35,45]

def merge_sorted_arrays(a4,a5):
    i,j=0,0
    merged = []
    while i<len(a4) and j<len(a5):
        if(a4[i]<a5[j]):
            merged.append(a4[i])
            i+=1
        else:
            merged.append(a5[j])
            j+=1
    merged.extend(a4[i:])
    merged.extend(a5[j:])

    return merged


# print(merge_sorted_arrays(a4,a5))


# Heapq merge method
import heapq
merged1 = list(heapq.merge(a4+a5))
print(merged1)
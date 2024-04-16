def insertionSort(a):
  if (n := len(a)) <= 1:
    return
  for i in range(1, n):
    k = a[i]
    j = i - 1
    while j >= 0 and k < a[j]:
      a[j + 1] = a[j]
      j -= 1
    a[j + 1] = k

str = [6, 4, 2, 1, 22, 9, 17]
insertionSort(str)
print(str) 

# result = [1, 2, 4, 6, 9, 17, 22]

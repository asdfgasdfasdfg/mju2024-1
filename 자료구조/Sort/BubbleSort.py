def bubbleSort(a):
  n = len(a)
  swapped = False
  for i in range(0, n - 1):
    for j in range(0, n - i - 1):
      if a[j] > a[j + 1]:
        swapped = True
        a[j], a[j + 1] = a[j + 1], a[j]
    if not swapped:
      return

str = [6, 4, 2, 1, 22, 9, 17]
bubbleSort(str)
print(str)

# result = [1, 2, 4, 6, 9, 17, 22]

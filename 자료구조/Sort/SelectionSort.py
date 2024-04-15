def selectionSort(a):
  for i in range(0, len(a)):
    min_i = i

    for j in range(i + 1, len(a)):
      if a[j] < a[min_i]:
        min_i = j
    (a[i], a[min_i]) = (a[min_i], a[i])

str = [6, 4, 2, 1, 22, 9, 17]
selectionSort(str)
print(str)     

# result = [1, 2, 4, 6, 9, 17, 22]

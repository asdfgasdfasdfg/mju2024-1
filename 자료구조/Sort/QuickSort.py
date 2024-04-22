def partition(a, low, high):
    pivot = a[low]
    i = low - 1

    a[i + 1], a[high] = a[high], a[i + 1]
    print(a)
    for j in range(low, high):
        if a[j] <= pivot:
            i += 1
            a[i], a[j] = a[j], a[i]
            print(a)

    a[i + 1], a[high] = a[high], a[i + 1]
    return i + 1

def quickSort(array, low ,high):
    if low < high:
        p = partition(array, low, high)
        quickSort(array, low, p - 1)
        quickSort(array, p + 1, high)

str = [5, 6, 4, 0, 2, 1, 7, 9, 3, 8]
quickSort(str, 0, len(str) - 1)
print()
print(str)

# result = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9]

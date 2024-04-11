# 리스트로 큐 구현

class queue():
    def __init__(self, maxSize):
        self.list = []
        self.maxSize = maxSize

    def enqueue(self, data):
        if self.isFull():
            print("queue is now Full!")
        else:
            self.list.append(data)

    def dequeue(self):
        if self.isEmpty():
            print("queue is now empty!")
        else:
            popData = self.list.pop(0)
            return popData
            
    def isFull(self):
        if len(self.list) == self.maxSize:
            return True
        else:
            return False

    def isEmpty(self):
        if len(self.list) == 0:
            return True
        else:
            return False

q = queue(3)

q.enqueue(1)
q.enqueue(2)
q.enqueue(3)
print(q.list)

q.enqueue(4)
print(q.list)

q.dequeue()
print(q.list)

q.dequeue()
print(q.list)

q.dequeue()
print(q.list)

q.dequeue()
print(q.list)
    

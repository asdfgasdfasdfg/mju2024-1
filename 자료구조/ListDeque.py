# 리스트로 덱 구현

class deque():
  def __init__(self, maxSize):
    self.list = []
    self.maxSize = maxSize

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

  def enqueueFront(self, data):
    if self.isFull():
      print("deque is now Full!")
    else:
      self.list.insert(0, data)

  def dequeueFront(self):
    if self.isEmpty():
      print("deque is now Empty!")
    else:
      popData = self.list.pop(0)
      return popData

  def enqueueRear(self, data):
    if self.isFull():
      print("deque is now Full!")
    else:
      self.list.append(data)
      
  def dequeueRear(self):
    if self.isEmpty():
      print("deque is now Empty!")
    else:
      popData = self.list.pop()
      return popData

d = deque(3)
d.enqueueFront(1)
d.enqueueFront(2)
d.enqueueFront(3)
print(d.list)

d.enqueueFront(4)
print(d.list)

d.dequeueFront()
print(d.list)

d.dequeueFront()
print(d.list)

d.dequeueFront()
print(d.list)

d.dequeueFront()
print(d.list)

d.enqueueRear(1)
d.enqueueRear(2)
d.enqueueRear(3)
print(d.list)

d.enqueueRear(4)
print(d.list)

d.dequeueRear()
print(d.list)

d.dequeueRear()
print(d.list)

d.dequeueRear()
print(d.list)

d.dequeueRear()
print(d.list)

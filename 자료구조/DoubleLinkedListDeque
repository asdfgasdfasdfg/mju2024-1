# 양방향 연결 리스트로 덱 구현

class deque():
  def __init__(self, maxSize):
    self.doubleList = DoubleLinkedList()
    self.maxSize = maxSize

  def isFull(self):
    if len(self.doubleList) == self.maxSize:
      return True
    else:
      return False
      
  def isEmpty(self):
    if len(self.doubleList) == 0:
      return True
    else:
      return False

  def enqueueFront(self, data):
    if self.isFull():
      print("deque is now Full!")
    else:
      self.doubleList.insert(0, data)

  def dequeueFront(self):
    if self.isEmpty():
      print("deque is now Empty!")
    else:
      popData = self.doubleList.delete(0)
      return popData

  def enqueueRear(self, data):
    if self.isFull():
      print("deque is now Full!")
    else:
      self.doubleList.insertAtBack(data)
      
  def dequeueRear(self):
    if self.isEmpty():
      print("deque is now Empty!")
    else:
      popData = self.doubleList.delete(-0) 
      return popData

class Node():
  def __init__(self, data):
    self.data = data
    self.left = None
    self.right = None

class DoubleLinkedList():
  def __init__(self):
    self.head = None
    self.tail = None
  
  def printHeadNodes(self, node:Node):
    cur = self.head
    while cur is not None:
      print(cur.data, end =' ')
      cur = cur.right
  
  def printTailNodes(self, node:Node):
    cur = self.tail
    while cur is not None:
      print(cur.data, end =' ')
      cur = cur.left

  def insertAtBack(self, value):
    newNode = Node(value)
    if self.head is None:
      self.head = newNode
      self.tail = newNode
      return

    newNode.left = self.tail
    self.tail = newNode
    (newNode.left).right = newNode
    
  def insert(self, position, value):
    newNode = Node(value)
    if (position == 0):
      newNode.right = self.head
      if self.head is not None:
        self.head.left = newNode
      self.head = newNode
      return

    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right
    
    newNode.right = cur.right
    cur.right = newNode
    newNode.left = cur
    (cur.right).left = newNode

  def delete(self, position):
    if position == 0:
      self.head = self.head.right
      if self.head is not None:
        self.head.left = None
      else:
        self.tail = None
      return

    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right

    if (cur.right == None):
      self.tail = self.tail.left
      return
    else:
      cur.right = cur.right.right
      if (cur.right != None):
        cur.right.left = cur

  def __len__(self):
    count = 0
    cur = self.head
    while cur:
      cur = cur.right
      count += 1
    return count
    
      
  def findNodes(self, value):
    cur = self.head
    while cur.right is not None:
      if cur.data == value:
        return value

      cur = cur.right
    raise RuntimeError("노드를 찾지 못했습니다.")    
    
d = deque(3)
d.enqueueFront(1)
d.enqueueFront(2)
d.enqueueFront(3)
d.doubleList.printHeadNodes(d.doubleList.head)
print()

d.enqueueFront(4)
d.doubleList.printHeadNodes(d.doubleList.head)
print()

d.dequeueFront()
d.doubleList.printHeadNodes(d.doubleList.head)
print()

d.dequeueFront()
d.doubleList.printHeadNodes(d.doubleList.head)
print()

d.dequeueFront()
d.doubleList.printHeadNodes(d.doubleList.head)
d.dequeueFront()

print()

d.enqueueRear(1)
d.enqueueRear(2)
d.enqueueRear(3)
d.doubleList.printTailNodes(d.doubleList.tail)
print()

d.enqueueRear(4)
d.doubleList.printTailNodes(d.doubleList.tail)
print()

d.dequeueRear()
d.doubleList.printTailNodes(d.doubleList.tail)
print()

d.dequeueRear()
d.doubleList.printTailNodes(d.doubleList.tail)
print()

d.dequeueRear()
d.doubleList.printTailNodes(d.doubleList.tail)
print()

d.dequeueRear()
d.doubleList.printTailNodes(d.doubleList.tail)

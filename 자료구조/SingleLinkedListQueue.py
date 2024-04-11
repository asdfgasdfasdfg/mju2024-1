# 연결 리스트로 큐 구현

class queue():
    def __init__(self, maxSize):
        self.singleList = SingleLinkedList()
        self.maxSize = maxSize

    def enqueue(self, data):
        if self.isFull():
            print("queue is now Full!")
        else:
            self.singleList.insertAtBack(data)

    def dequeue(self):
        if self.isEmpty():
            print("queue is now empty!")
        else:
            popData = self.singleList.delete(0)
            return popData
            
    def isFull(self):
        if len(self.singleList) == self.maxSize:
            return True
        else:
            return False

    def isEmpty(self):
        if len(self.singleList) == 0:
            return True
        else:
            return False

class Node():
  def __init__(self, data):
    self.data = data
    self.right = None

def printNodes(node:Node):
  cur = node
  while cur is not None:
    print(cur.data, end =' ')
    cur = cur.right

class SingleLinkedList:
  def __init__(self):
    self.head = None

  def insertAtBack(self, value):
    newNode = Node(value)
    if self.head is None:
        self.head = newNode
        return

    cur = self.head
    while cur.right is not None:
      cur = cur.right
    cur.right = newNode
    
  def insert(self, position, value):
    newNode = Node(value)
    if (position == 0):
      newNode.right = self.head
      self.head = newNode
      return

    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right

    newNode.right = cur.right
    cur.right = newNode

  def delete(self, position):
    if (position == 0):
      self.head = self.head.right
      return
    
    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right

    cur.right = cur.right.right

  def findNode(self, value):
    cur = self.head
    while cur.right is not None:
      if (cur.data == value):
        return value

      cur = cur.right
    raise RuntimeError("노드를 찾지 못했습니다.")

  def __len__(self):
    count = 0
    cur = self.head
    while cur:
        count += 1
        cur = cur.right
    return count

q = queue(3)

q.enqueue(1)
q.enqueue(2)
q.enqueue(3)
printNodes(q.singleList.head)
print()

q.enqueue(4)
printNodes(q.singleList.head)
print()

q.dequeue()
printNodes(q.singleList.head)
print()

q.dequeue()
printNodes(q.singleList.head)
print()

q.dequeue()
printNodes(q.singleList.head)
print()

q.dequeue()
printNodes(q.singleList.head)
print()
    

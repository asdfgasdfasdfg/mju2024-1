class stack():
    def __init__(self, maxSize):
        self.maxSize = maxSize
        self.singleList = SingleLinkedList()
        
    def push(self, data):
        if self.isStackFull():
            print("Stack is Full!")
        else:
            self.singleList.insert(0, data)

    def isStackFull(self):
        if len(self.singleList) == self.maxSize:
            return True
        else:
            return False

    def isStackEmpty(self):
        if len(self.singleList) == 0:
            return True
        else:
            return False

    def pop(self):
        if self.isStackEmpty():
            print("Stack is Empty!")
        else:
            popData = self.singleList.delete(0)
            return popData

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
    
s = stack(3) 

s.push(1)
s.push(2)
s.push(3)
s.push(4)
printNodes(s.singleList.head)
print()

s.pop()
printNodes(s.singleList.head)
print()

s.pop()
printNodes(s.singleList.head)
print()

s.pop()
printNodes(s.singleList.head)
print()

s.pop()
printNodes(s.singleList.head)
print()



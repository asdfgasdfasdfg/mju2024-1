# 원형 연결 리스트
class Node():
  def __init__(self, data):
    self.data = data
    self.right = None

class circularLinkedList():
  def __init__(self):
    self.head = None

  def printNodes(self, node:Node):
    cur = node
    while cur.right is not self.head:
      print(cur.data, end =' ')
      cur = cur.right
    print(cur.data, end =' ')

  def insertAtBack(self, value):
    newNode = Node(value)
    cur = self.head
    while cur.right is not self.head:
      cur = cur.right
    
    cur.right = newNode
    newNode.right = self.head

  def insert(self, position, value):
    newNode = Node(value)
    if (position == 0):
      newNode.right = self.head
      cur = self.head
      while cur.right is not self.head:
        cur = cur.right
      
      cur.right = newNode
      self.head = newNode
      return   
    
    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right

    newNode.right = cur.right
    cur.right = newNode

  def delete(self, position):
    if position == 0:
      cur = self.head
      while cur.right is not self.head:
        cur = cur.right
      
      cur.right = self.head.right
      self.head = self.head.right
      return

    cur = self.head
    for i in range(0, position - 1):
      cur = cur.right

    cur.right = cur.right.right

  def findNodes(self, value):
    cur = self.head
    while cur.right is not self.head:
      if (cur.data == value):
        return value

      cur = cur.right
    
    raise RuntimeError("노드를 찾지 못했습니다.")

newCircularList = circularLinkedList()

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)

n1.right = n2
n2.right = n3
n3.right = n4
n4.right = n1

newCircularList.head = n1
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.insertAtBack(11)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.insert(4, 22)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.insert(6, 322)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.insert(0, 111)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.delete(7)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.delete(0)
newCircularList.printNodes(newCircularList.head)
print()

newCircularList.findNodes(4)

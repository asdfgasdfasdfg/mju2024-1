# 양방향 연결 리스트

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
    while cur.right is not None:
      print(cur.data, end =' ')
      cur = cur.right
    print(cur.data)
  
  def printTailNodes(self, node:Node):
    cur = self.tail
    while cur.left is not None:
      print(cur.data, end =' ')
      cur = cur.left
    print(cur.data)

  def insertAtBack(self, value):
    newNode = Node(value)
    newNode.left = self.tail
    self.tail = newNode
    (newNode.left).right = newNode
    
  def insert(self, position, value):
    newNode = Node(value)
    if (position == 0):
      newNode.right = self.head
      self.head = newNode
      (self.head.right).left = newNode
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
      
  def findNodes(self, value):
    cur = self.head
    while cur.right is not None:
      if cur.data == value:
        return value

      cur = cur.right
    raise RuntimeError("노드를 찾지 못했습니다.")    
    
newDoubleLinkedList = DoubleLinkedList()

newDoubleLinkedList.head = n1
newDoubleLinkedList.tail = n4

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)

n1.right = n2
n2.right = n3
n3.right = n4

n4.left = n3
n3.left = n2
n2.left = n1

newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.printTailNodes(newDoubleLinkedList.tail)
print()

newDoubleLinkedList.insertAtBack(11)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.insert(0, 22)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.insert(2, 33)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.insert(7, 77)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.delete(0)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.delete(3)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.delete(5)
newDoubleLinkedList.printHeadNodes(newDoubleLinkedList.head)
print()

newDoubleLinkedList.findNodes(1)

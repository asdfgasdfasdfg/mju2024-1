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

newSingleList = SingleLinkedList()

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)

n1.right = n2
n2.right = n3
n3.right = n4

newSingleList.head = n1
printNodes(newSingleList.head)
print()

newSingleList.insertAtBack(6)
printNodes(newSingleList.head)
print()

newSingleList.insert(0, 11) 
printNodes(newSingleList.head)
print()

newSingleList.insert(0, 21)  
printNodes(newSingleList.head)
print()

newSingleList.insert(7, 331)  
printNodes(newSingleList.head)
print()

newSingleList.delete(6)  
printNodes(newSingleList.head)
print()

newSingleList.delete(0)  
printNodes(newSingleList.head)
print()

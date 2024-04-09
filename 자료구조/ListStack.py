# 리스트로 스택 구현
class stack():
  def __init__(self, max_size):
    self.list = []
    self.max_size = max_size

  def isStackFull(self):
    if len(self.list) == self.max_size:
      return True
    else:
      return False

  def push(self, data):
    if self.isStackFull():
      print("Stack is Full!")
    else:
      self.list.append(data)
  

  def isStackEmpty(self):
    if len(self.list) == 0:
      return True
    else:
      return False
    
  def pop(self):
    if self.isStackEmpty():
      print("Stack is Empty!")
    else:
      return self.list.pop()
      

s = stack(3)

s.push(1)
s.push(2)
s.push(3)
print(s.list)

s.push(4)
print(s.list)

s.pop()
print(s.list)

s.pop()
print(s.list)

s.pop()
print(s.list)

s.pop()
print(s.list)

  

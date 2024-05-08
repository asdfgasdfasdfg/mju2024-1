class treeNode():
    def __init__(self, data, left = None, right = None):
        self.data = data
        self.left = left
        self.right = right

def preorder(node):
    print(node.data, end="")
    if node.left != None:
        preorder(tree[node.left])
    if node.right != None:
        preorder(tree[node.right])

def inorder(node):
    if node.left != None:
        inorder(tree[node.left])
    print(node.data, end='')
    if node.right != None:
        inorder(tree[node.right])

def postorder(node):
    if node.left != None:
        postorder(tree[node.left])
    if node.right != None:
        postorder(tree[node.right])
    print(node.data, end='')

n = int(input())
tree = {}

for i in range(n):
    data, left, right = input().split()
    if left == '.':
        left = None
    if right == '.':
        right = None
    tree[data] = treeNode(data, left, right)

preorder(tree['A'])
print()
inorder(tree['A'])
print()
postorder(tree['A'])

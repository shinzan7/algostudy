N = int(input())
orders = list(map(str, input().split()))

# N = 5
# orders = ["R", "R", "R", "U", "D", "D"]

# 0123 -> R L D U
dx = [1,-1,0,0]
dy = [0,0,1,-1]
idx = 0

def isIn(r, c):
    return r>=1 and r<=N and c>=1 and c<=N

class Point:
    def __init__(self, r, c):
        self.r = r
        self.c = c
    def move(self, idx):
        self.r += dx[idx]
        self.c += dy[idx]

travler = Point(1, 1)

for order in orders:
    idx = 0
    if(order == "L"):
        idx = 1
    elif(order == "D"):
        idx = 2
    elif(order == "U"):
        idx = 3
    
    if(isIn(travler.r + dx[idx], travler.c + dy[idx])):
        travler.move(idx)

print(str(travler.c) +" "+ str(travler.r))

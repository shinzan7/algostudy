order = input()
# order = "a1"

c = ord(order[0]) - ord("a") + 1
r = int(order[1])

def isIn(r, c):
    return r>=1 and r<=8 and c>=1 and c<=8

# 상하좌우 2개씩
dx = [1,-1,1,-1,-2,-2,2,2]
dy = [-2,-2,2,2,1,-1,1,-1]

count = 0

for idx in range(8):
    if(isIn(r+dy[idx], c+dx[idx])):
        count += 1

print(count)
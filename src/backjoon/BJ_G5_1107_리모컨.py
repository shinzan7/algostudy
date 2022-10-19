from collections import deque

dx, dy = [-1,1,0,0], [0,0,1,-1]
R, C = map(int, input().split())

graph = []
for i in range(R):
    graph.append(list(map(int, input())))

is_visit = []
for i in range(R):
    is_visit.append([False] * C)

q = deque([])
count = 0

def bfs():
    while q:
        r, c = q.popleft()
        for i in range(4):
            nr, nc = r + dx[i], c + dy[i]
            if 0 <= nr < R and 0 <= nc < C and graph[nr][nc] == 0 and is_visit[nr][nc] == False:
                q.append([nr, nc])
                is_visit[nr][nc] = True

for r in range(R):
    for c in range(C):
        if(graph[r][c] == 0 and is_visit[r][c] == False):
            q.append([r, c])
            is_visit[r][c] = True
            count += 1
            bfs()

print(count)


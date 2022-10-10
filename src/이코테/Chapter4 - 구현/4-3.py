# 4-3 게임 개발

n,m = map(int, input().split())
# m, n = 4, 4

#방문배열
is_visit = [[False] * m for i in range(n)]

#북동남서 0123
dr = [-1, 0, 1, 0]
dc = [0, 1, 0, -1]

r, c, dir = map(int, input().split())
# r, c, dir = 1, 1, 0

game_map = []
for i in range(n):
    game_map.append(list(map(int, input().split())))

class Character():
    def __init__(self,r ,c ,dir):
        self.r = r
        self.c = c
        self.dir = dir
        self.count = 0
    def move(self, left):
        self.r += dr[left]
        self.c += dc[left]

cur = Character(r, c, dir)
is_visit[r][c] = True
cur.count += 1

turn_count = 0
while True:
    left = (cur.dir + 3) % 4
    nr = cur.r + dr[left]
    nc = cur.c + dc[left]
    # 사방이 바다거나 갔던 곳이면 뒤로 이동
    if(turn_count == 4):
        back = (cur.dir + 2) % 4
        br = cur.r + dr[back]
        bc = cur.c + dc[back]
        #뒤로 이동할 수 있는 경우
        if(game_map[br][bc] == 0):
            cur.r = br
            cur.c = bc
            continue
        #뒤로 이동할 수 없는 경우
        else:
            break

    # 왼쪽방향 갈 수 있으면 이동
    if(is_visit[nr][nc] == False and game_map[nr][nc] == 0):
        cur.dir = left
        cur.move(left)
        turn_count = 0
        is_visit[nr][nc] = True
        cur.count += 1
    # 갈 수 없으면 회전만하기
    else:
        cur.dir = left
        turn_count += 1

print(cur.count)
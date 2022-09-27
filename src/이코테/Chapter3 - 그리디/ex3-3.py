# 숫자 카드 게임
R, C = map(int, input().split())

result = 0

for i in range(R):
    data = list(map(int, input().split()))
    result = max(result, min(data))

print(result)
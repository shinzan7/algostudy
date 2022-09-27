# 거스름돈
# 500원 100원 50원 10원 동전이 있음
# 거슬러 줘야 될 돈이 N원일 때 가장 최소의 동전 개수를 구하여라

# N = input()
N = 1260
cnt = 0

coin_types = [500, 100, 50, 10]

for coin in coin_types:
    cnt += N // coin
    # print(f"{coin}원 짜리 {N//coin}개 추가!")
    N %= coin
    # print(f"잔돈은 {N}")

print(cnt)
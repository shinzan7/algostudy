# 큰 수의 법칙
# 다양한 수로 이루어진 배열이 있을 때 주어진 수들을 M번 더하여 가장 큰 수를 만드는 법칙
# 단, 배열의 특정한 인덱스에 해당하는 수가 연속해서 K번을 초과하여 더해질 수 없는 것이 이 법칙의 특성이다.

N, M, K = map(int, input().split())
data = list(map(int, input().split()))

# N, M, K = 5, 8, 3
# data = [2,4,5,4,6]

data.sort(reverse=True)

# M을 K+1의 배수만큼 처리
repeat = M // (K+1)
result = repeat * (data[0]*3 + data[1]) + (M % (K+1))*data[0]

print(result)
import sys
input = sys.stdin.readline
# 행렬 크기 입력
N,M = map(int, input().split())

# DP 테이블
dp = []

# DP 테이블에 각 행 추가
for i in range(N) :
    dp.append(list(map(int,input().split())))
    
# 1번째 행 업데이트 // 왼쪽에서 오른쪽으로
for j in range(1,M) :
    dp[0][j] += dp[0][j-1]
    
# 나머지 행 업데이트
for i in range(1,N) :
    # 임시 리스트 생성
    left_to_right = dp[i][:]
    right_to_left = dp[i][:]
    
    # 왼쪽에서 오른쪽으로 가는 경우
    for j in range(M) :
        # 첫 번째 열 예외처리 : 위에서 아래로 오는 경우
        if j == 0 :
            left_to_right[j] += dp[i-1][j]
        # 나머지 열 : 위에서 내려오는 경우, 왼쪽에서 오는 경우를 비교
        else :
            left_to_right[j] += max(dp[i-1][j],left_to_right[j-1])
    
    # 오른쪽에서 왼쪽으로 가는경우
    for j in range(M-1,-1,-1) :
        #마지막 열 예외처리 : 위에서 아래로 오는 경우
        if j == M-1 :
            right_to_left[j] += dp[i-1][j]
        else :
            right_to_left[j] += max(dp[i-1][j],right_to_left[j+1])
    
    # left_to_right , right_to_left 를 서로 비교, 각 좌표값을 최대값으로 업데이트
    for j in range(M) :
        dp[i][j] = max(left_to_right[j],right_to_left[j])
        

print(dp[N-1][M-1])
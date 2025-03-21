import sys
from collections import deque

def find(a,b) :
    visited[a][b] = 1
    q = deque()
    q.append((a,b))
    
    while q :
        x,y = q.popleft()
        for i in range(4) :
            nx = x + dx[i]
            ny = y + dy[i]
            
            if 0 <= nx < N and 0 <= ny < N  and visited[nx][ny] == 0 and board[x][y] == board[nx][ny] :
                visited[nx][ny] = 1
                q.append((nx,ny))

def check() :
    cnt = 0
    for i in range(N) :
        for j in range(N) :
            if visited[i][j] == 0 :
                find(i,j)
                cnt += 1
    
    return cnt


# 4 방향 정의 | 북/동/남/서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

N = int(sys.stdin.readline())
board = []
for i in range(N) :
    board.append(list(sys.stdin.readline().strip()))
    
visited = [[0] * N for _ in range(N)]

## 정상인 경우

res_normal = check()

## 색약인 경우

visited = [[0] * N for _ in range(N)]
# G를 R로 변환
for i in range(N) :
    for j in range(N) :
        if board[i][j] == 'G' :
            board[i][j] = 'R'

res_disabled = check()

print(res_normal,res_disabled)
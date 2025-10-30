import sys
from collections import deque
input = sys.stdin.readline


## 북 / 동 / 남 / 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

## N = 행 , M = 열
N,M = map(int,input().split())
board = []

def bfs(sx,sy,visited,board) :
    q = deque()
    q.append([sx,sy])
    visited[sx][sy] = 0
    
    while q :
        x,y = q.popleft()
        
        for d in range(4) :
            nx = x + dx[d]
            ny = y + dy[d]
            
            if nx >= 0 and nx < N and ny >= 0 and ny < M and board[nx][ny] == 1 and visited[nx][ny] == 0:
                visited[nx][ny] = visited[x][y] + 1
                q.append([nx,ny])
    
    return visited

for i in range(N) :
    board.append(list(map(int,input().split())))
    
## 시작 지점 찾기
sx = -1
sy = -1
for i in range(N) :
    for j in range(M) :
        if board[i][j] == 2 :
            sx = i
            sy = j
            
visited = [[0 for j in range(M)] for i in range(N)]

after_visited = bfs(sx,sy,visited,board)
## 원래 갈 수 있는 땅인 부분 중에서 도달할 수 없는 위치는 -1을 출력한다.
for i in range(N) :
    for j in range(M) :
        if after_visited[i][j] == 0 and board[i][j] == 1 :
            after_visited[i][j] = -1

for i in range(N) :
    print(' '.join(list(map(str,after_visited[i]))))
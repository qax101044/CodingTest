from collections import deque
from itertools import combinations
import sys
input = sys.stdin.readline

dx = [-1,0,1,0]
dy = [0,1,0,-1]

N, M = map(int, input().split())
board = []
virus = []
empty = []
answer = 0

for i in range(N):
    row = list(map(int, input().split()))
    board.append(row)
    for j in range(M):
        if row[j] == 0:
            empty.append((i, j))
        elif row[j] == 2:
            virus.append((i, j))

def bfs(temp):
    q = deque(virus)
    while q:
        x, y = q.popleft()
        for d in range(4):
            nx, ny = x + dx[d], y + dy[d]
            if 0 <= nx < N and 0 <= ny < M and temp[nx][ny] == 0:
                temp[nx][ny] = 2
                q.append((nx, ny))
    global answer
    cnt = sum(row.count(0) for row in temp)
    answer = max(answer, cnt)

for walls in combinations(empty, 3):
    temp = [row[:] for row in board]
    for x, y in walls:
        temp[x][y] = 1
    bfs(temp)

print(answer)
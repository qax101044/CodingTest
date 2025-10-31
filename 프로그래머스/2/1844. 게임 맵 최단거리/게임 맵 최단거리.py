from collections import deque

## 북 / 동 / 남 / 서
dx = [-1,0,1,0]
dy = [0,1,0,-1]

def bfs(maps, visited) :
    q = deque()
    q.append([0,0])
    visited[0][0] = 1
    
    while q :
        sx,sy = q.popleft()
        
        for d in range(4) :
            nx = sx + dx[d]
            ny = sy + dy[d]
            
            if nx >= 0 and nx < len(maps) and ny >= 0 and ny < len(maps[0]) :
                if visited[nx][ny] == 0 and maps[nx][ny] == 1 :
                    visited[nx][ny] = visited[sx][sy] + 1
                    q.append([nx,ny])
    
    
    

def solution(maps):
    
    visited = [[0 for j in range(len(maps[0]))] for i in range(len(maps))]
    bfs(maps,visited)
    
    answer = visited[len(maps) - 1][len(maps[0]) - 1]
    if answer == 0 :
        answer = -1
    return answer
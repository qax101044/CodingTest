from collections import deque

def solution(land):
    answer = 0
    
    # 4방향 북/동/남/서
    dx = [-1,0,1,0]
    dy = [0,1,0,-1]
    
    visited = [[0 for j in range(len(land[0]))] for i in range(len(land))]
    answer = [0 for j in range(len(land[0]))]
    
    def bfs(a,b) :
        q = deque()
        q.append((a,b))
        cnt = 0
        temp = []
        visited[a][b] = 1
        
        while q :
            x,y = q.popleft()
            cnt += 1
            temp.append(y)
            
            for i in range(4) :
                nx = x + dx[i]
                ny = y + dy[i]
                
                if 0 <= nx < len(land) and 0 <= ny < len(land[0]) and visited[nx][ny] == 0 and land[nx][ny] == 1 :
                    q.append((nx,ny))
                    visited[nx][ny] = 1
        y_min = min(temp)
        y_max = max(temp)
        ## print(temp,cnt)
        for i in range(y_min,y_max+1) :
            answer[i] += cnt
            
    for i in range(len(land)) :
        for j in range(len(land[0])) :
            if land[i][j] == 1 and visited[i][j] == 0:
                bfs(i,j)
                
    return max(answer)
from itertools import combinations

def check(candi,answer) :
    visited = []
    total = 0
    for x,y in candi :
        visited.append([x,y])
        total += board[x][y]
        
        for d in range(4) :
            nx = x + dx[d]
            ny = y + dy[d]
            
            if [nx,ny] in visited :
                return answer
            
            else :
                total += board[nx][ny]
                visited.append([nx,ny])
    
    answer = min(answer,total)
    return answer
    
N = int(input())

## 북 / 동 / 남 /서
dx = [-1,0,1,0]
dy = [0,1,0,-1]
result = []
board = []
answer = int(1e9)

for i in range(N) :
    board.append(list(map(int,input().split())))

for i in range(1,N-1) :
    for j in range(1,N-1) :
        result.append([i,j])

for i in list(combinations(result,3)) :
    answer = check(i,answer)

print(answer)
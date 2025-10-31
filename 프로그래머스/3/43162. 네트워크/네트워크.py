## DFS 풀이
def dfs(n, computers, com, visited) :
    visited[com] = 1
    for connect in range(n) :
        ## 네트워크가 연결된 컴퓨터인 경우
        if connect != com and computers[com][connect] == 1 :
            if visited[connect] == 0 :
                dfs(n, computers, connect, visited)

def solution(n, computers):
    answer = 0
    visited = [0 for j in range(n)]
    
    for com in range(n) :
        if visited[com] == 0 :
            dfs(n, computers, com, visited)
            answer += 1
    return answer
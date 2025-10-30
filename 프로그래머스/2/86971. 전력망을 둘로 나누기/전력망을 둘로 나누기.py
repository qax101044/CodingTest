from collections import deque

def BFS(start, graph, visited, link_board) :
    q = deque([start])
    visited[start] = 1
    cnt = 1
    
    while q :
        s = q.popleft()
        for adj in graph[s] : 
            if visited[adj] == 0 and link_board[start][adj] :
                q.append(adj)
                visited[adj] = 1
                cnt += 1
    return cnt

def solution(n, wires):
    answer = n
    
    ## 간선 체크
    link_board = [[1 for j in range(n+1)] for i in range(n+1)]
    ## 송전탑 그래프
    graph = [[] for i in range(n+1)]
    
    ## 그래프 채우기
    for a,b in wires :
        graph[a].append(b)
        graph[b].append(a)
        
    for a,b in wires :
        visited = [0 for j in range(n+1)]
        link_board[a][b] = 0 ## a,b 그룹에 붙어있는 송전탑의 개수를 세기 위해 a에서 b로 가는 간선을 끊어봄
        cnt_a = BFS(a, graph, visited, link_board) ## 이 때, a와 붙어있는 송전탑 개수
        cnt_b = BFS(b, graph, visited, link_board) ## 이 때, b와 붙어있는 송전탑 개수
        link_board[a][b] = 1 ## a,b 그룹
        
        answer = min(answer, abs(cnt_a - cnt_b))
        
        
    return answer
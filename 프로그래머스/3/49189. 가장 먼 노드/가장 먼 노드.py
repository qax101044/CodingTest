from collections import deque

def solution(n, edge):
    answer = 0
    graph = [[] for j in range(n+1)]
    distance = [-1 for j in range(n+1)]
    
    ## 연결된 노드 정보 추가
    for node in edge :
        graph[node[0]].append(node[1])
        graph[node[1]].append(node[0])
    
    q = deque()
    q.append(1)
    distance[1] = 0
    
    ## BFS 수행
    while q :
        n_node = q.popleft()
        
        ## 현재 노드에서 이동 가능한 노드 탐색
        for i in graph[n_node] :
            if distance[i] == -1 :
                q.append(i)
                distance[i] = distance[n_node] + 1
    
    for d in distance :
        if d == max(distance) :
            answer += 1
    return answer
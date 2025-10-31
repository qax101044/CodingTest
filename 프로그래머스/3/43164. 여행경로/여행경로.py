## 주어지는 항공권 모두 사용
## 가능한 경로 2개 이상일 경우 알파벳 순서가 앞서는 경로를 return
## 항상 ICN에서 출발

def solution(tickets):
    answer = []
    visited = [0 for j in range(len(tickets))]
    
    def dfs(start,path) :
        ## 주어진 항공권 모두 사용
        if len(path) == len(tickets) + 1 :
            answer.append(path)
            return
        
        ## 주어진 항공권 아직 덜 사용
        for idx, ticket in enumerate(tickets) :
            if ticket[0] == start and visited[idx] == 0 :
                visited[idx] = 1
                ## path + [새 값] 형식으로 넘김
                dfs(ticket[1],path + [ticket[1]])
                visited[idx] = 0
    
    dfs("ICN", ["ICN"])
    answer.sort()
    return answer[0]
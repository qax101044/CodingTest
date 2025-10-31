## 플로이드 와샬

def solution(n, results):
    answer = 0
    rank = [[0 for j in range(n)] for i in range(n)]
    
    for win, lose in results :
        rank[win-1][lose-1] = 1
        rank[lose-1][win-1] = -1
    
    for k in range(n) :
        for i in range(n) :
            for j in range(n) :
                if i == j :
                    continue
                if rank[i][j] != 0 :
                    continue
                if rank[i][k] == 1 and rank[k][j] == 1 :
                    rank[i][j] = 1
                    rank[j][i] = -1
    print(rank)
    for per in rank :
        if per.count(0) == 1 :
            answer += 1
    
    return answer
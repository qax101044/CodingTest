from collections import deque

def solution(progresses, speeds):
    answer = []
    q = deque()
    s = deque()
    
    for i in progresses :
        q.append(i)
    
    for i in speeds :
        s.append(i)
        
    while q :
        cnt = 0
        
        for j in range(len(q)) :
            q[j] += s[j]
            
        for k in q :
            if k >= 100 :
                cnt += 1
            else :
                break
        
        for _ in range(cnt) :
            q.popleft()
            s.popleft()
        
        if cnt > 0 :
            answer.append(cnt)
            
    return answer
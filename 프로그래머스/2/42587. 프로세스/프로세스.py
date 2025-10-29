from collections import deque

def solution(priorities, location):
    answer = 0
    
    q = deque()
    for i in range(len(priorities)) :
        q.append([priorities[i],i])
    
    while q :
        arr = q.popleft()
        
        if q :
            maxValue = max(q, key=lambda x: x[0])[0]
            
            if maxValue > arr[0] :
                q.append(arr)
            else :
                answer += 1
                if arr[1] == location :
                    return answer
        
        else :
            answer += 1
        
    return answer
from collections import deque

def solution(prices):
    answer = []
    
    q = deque(prices)
    
    while q :
        s = q.popleft()
        time = 0
        if q :
            for i in q :
                time += 1
                if i < s :
                    break
        answer.append(time)
    return answer
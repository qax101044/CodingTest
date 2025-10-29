from collections import deque

def solution(s):
    
    q = deque(list(s))
    ##print(q)
    
    L_count = 0
    R_count = 0
    
    while q :
        s = q.pop()
        
        if s == ")" :
            R_count += 1
        else :
            L_count += 1
        
        if L_count > R_count :
            return False
    
    if L_count == R_count :
        return True
    else :
        return False
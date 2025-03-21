from collections import deque

def solution(cacheSize, cities):
    answer = 0
    
    for i in range(len(cities)) :
        cities[i] = cities[i].lower()
    
    ##print(cities)
    q = deque()
    
    for city in cities :
        
        ## cacheSize == 0인 경우
        if cacheSize == 0 :
            answer += 5
            continue
        
        ## 큐가 아예 비어있을 경우
        if len(q) == 0 :
            q.append(city)
            answer += 5
            continue
        
        ## cache hit
        if city in q :
            q.remove(city)
            q.append(city)
            answer += 1
        
        ## cache miss
        else :
            ## cacheSize에 도달한 경우
            if  cacheSize == len(q) :
                q.popleft()
            
            q.append(city)
            answer += 5
    
    return answer
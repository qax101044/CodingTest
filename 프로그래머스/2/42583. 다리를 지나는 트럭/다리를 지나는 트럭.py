from collections import deque

def solution(bridge_length, weight, truck_weights):
    answer = 0
    
    truck = []
    for i in range(len(truck_weights)) :
        truck.append([truck_weights[i],bridge_length])
    
    wait = deque(truck)
    bridge = deque()
    
    w = weight
    
    while wait or bridge :
        answer += 1
        L = len(bridge)
        ## (다리) => (CLEAR)
        for j in range(L) :
            ##print(answer, bridge)
            s = bridge.popleft()
            temp = [s[0],s[1]-1]
            
            
            if temp[1] > 0 :
                bridge.append(temp)
            else :
                w += temp[0]
        
        ## (대기) => (다리)
        if wait :
            temp_w = wait[0][0]
            
            if w - temp_w >= 0 :
                w -= temp_w
                bridge.append(wait.popleft())
    return answer
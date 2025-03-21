def solution(N, stages):
    answer = []
    ratio = {}
    
    all_player = len(stages)
    
    for i in range(1,N+1) :
        if all_player == 0 :
            ratio[i] = 0
            answer.append([ratio[i],i])
        else :
            ratio[i] = stages.count(i) / all_player
            all_player -= stages.count(i)
            answer.append([ratio[i],i])
    
    answer.sort(key=lambda x: -x[0])
    answer2 = []
    for x,y in answer :
        answer2.append(y)
    return answer2
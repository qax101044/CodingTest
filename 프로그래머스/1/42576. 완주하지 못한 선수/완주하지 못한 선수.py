def solution(participant, completion):
    answer = ""
    par = {}
    
    for i in participant :
        if i in par :
            par[i] += 1
        else :
            par[i] = 1
    
    for i in completion :
        par[i] -= 1
    
    for i in participant :
        if par[i] != 0 :
            answer = i
    return answer
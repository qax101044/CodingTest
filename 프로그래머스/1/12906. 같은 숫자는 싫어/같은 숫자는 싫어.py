def solution(arr):
    answer = []
    chk = -1
    
    for i in arr :
        if i != chk :
            answer.append(i)
            chk = i
    return answer
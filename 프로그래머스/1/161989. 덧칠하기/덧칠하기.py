def solution(n, m, section):
    answer = 0
    
    arr = [1 for j in range(n)]
    for i in section :
        arr[i-1] = 0
    
    for i in range(n - m + 1) :
        #print(arr)
        if arr[i] == 0 :
            for j in range(i,i + m) :
                arr[j] = 1
            answer += 1
    
    for i in range(n - m + 1, n) :
        if arr[i] == 0 :
            answer += 1
            break
    return answer
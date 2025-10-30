## 에라토스테네스의 체 : 2부터 시작해서 특정 숫자의 배수에 해당하는 숫자들은 모두 지운다.
##                    이미 지워진 숫자는 건너뛴다.

def solution(n):
    answer = 0
    arr = [1 for _ in range(n+1)]
    
    for i in range(2, int(n**(0.5)) +  1) :
        ## 소수일 경우
        if arr[i] == 1 :
            j = 2
            
            while i*j <= n :
                arr[i*j] = 0
                j += 1
    for i in range(2,n+1) :
        if arr[i] == 1 :
            answer += 1
    return answer
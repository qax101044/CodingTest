## N/2 마리까지 가져가는 거 허용

def solution(nums):
    answer = 0
    
    poke_dic = {}
    
    N = len(nums) // 2
    
    for i in nums :
        poke_dic[i] = 1
    
    if len(poke_dic) > N :
        answer = N
    else :
        answer = len(poke_dic)
    return answer
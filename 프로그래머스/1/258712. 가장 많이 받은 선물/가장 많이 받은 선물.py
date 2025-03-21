from itertools import combinations

def solution(friends, gifts):
    dic = {}
    score = {}
    next_month = {}
    for i in friends :
        score[i] = 0
        next_month[i] = 0
        
    for gift in gifts :
        giver,taker = gift.split()
        key = giver + ' ' + taker
        chk_reversed_key = taker + ' ' + giver
        
        # dic[key]가 존재하지 않으면 default 값인 0을 반환하고, 이후 1을 더해 다시 할당합니다.
        dic[key] = dic.get(key, 0) + 1
        score[giver] += 1
        score[taker] -= 1
        dic[chk_reversed_key] = dic.get(chk_reversed_key,0) + 0 
        
    answer = 0

    chk_list = list(combinations(friends,2))

    for x,y in chk_list :
        #print(x,y)
        A = x + ' ' + y
        B = y + ' ' + x
        a = dic.get(A,0)
        b = dic.get(B,0)
        #print(a,b)
        
        if a == b :
            if score[x] > score[y] :
                next_month[x] += 1
                #next_month[y] -= 1
            elif score[x] < score[y] :
                #next_month[x] -= 1
                next_month[y] += 1
        elif a > b :
            next_month[x] += 1
            #next_month[y] -= 1
        else :
            #next_month[x] -= 1
            next_month[y] += 1
        #print(next_month)
            
                
    #print(next_month)
    answer = max(next_month.values())
    return answer
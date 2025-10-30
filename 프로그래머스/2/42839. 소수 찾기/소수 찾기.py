from itertools import permutations

def is_prime(x) :
    if x < 2 :
        return False
    for i in range(2,x) :
        if x % i == 0 :
            return False
    
    return True

def solution(numbers):
    answer = 0
    p = []
    result = []
    
    for i in range(1,len(numbers) + 1) :
        p.extend(permutations(numbers,i))
        for i in p :
            result.append(int(''.join(i)))
    
    for i in set(result) :
        if is_prime(i) :
            answer += 1
    return answer
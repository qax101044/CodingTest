def solution(citations):
    answer = 0
    citations.sort(reverse=True)
    
    for i in range(len(citations)) :
        
        ## [6,5,3,1,0]
        if citations[i] < i + 1 :
            return i
    return len(citations)
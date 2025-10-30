def solution(sizes):
    answer = 0
    
    w_arr = []
    h_arr = []
    
    for i in range(len(sizes)) :
        w_arr.append(max(sizes[i][0],sizes[i][1]))
        h_arr.append(min(sizes[i][1],sizes[i][0]))
        
    return max(w_arr) * max(h_arr)
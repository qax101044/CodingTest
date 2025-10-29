def solution(array, commands):
    answer = []
    
    for i in range(len(commands)) : 
        
        start = commands[i][0] - 1
        end = commands[i][1]
        
        temp = array[start:end]
        temp.sort()
        ##print(temp)
        answer.append(temp[commands[i][2]-1])
        
    return answer
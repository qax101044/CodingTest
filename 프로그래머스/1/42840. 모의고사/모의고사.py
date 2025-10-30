def solution(answers):
    answer = []
    
    student_A = [1, 2, 3, 4, 5]
    student_B = [2, 1, 2, 3, 2, 4, 2, 5]
    student_C = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    score = [0,0,0]
    
    for i in range(len(answers)) :
        A = student_A[i % len(student_A)]
        B = student_B[i % len(student_B)]
        C = student_C[i % len(student_C)]
        
        if answers[i] == A :
            score[0] += 1
        if answers[i] == B :
            score[1] += 1
        if answers[i] == C :
            score[2] += 1
        
    maxValue = max(score)
    for i in range(len(score)) :
        if maxValue == score[i] :
            answer.append(i+1)
    return answer

def solution(word) :
    dic = []
    words = "AEIOU"
    
    def dfs(cnt,w) :
        ## 최대 길이 = 5
        if cnt == 5 :
            return
        for i in range(len(words)) :
            dic.append(w + words[i])
            dfs(cnt + 1, w + words[i])
    dfs(0,'')
        

    return dic.index(word) + 1
def solution(s):
    str_num = ["zero","one","two","three","four","five","six","seven","eight","nine"]
    for i, word in enumerate(str_num) :
        s = s.replace(word, str(i))
    return int(s)
N = int(input())

arr = []
for i in range(N) :
    A,B,C,D = input().split()
    arr.append([A,int(B),int(C),int(D)])

arr.sort(key=lambda x:(-x[1],x[2],-x[3],x[0]))

for i in range(N) :
    print(arr[i][0])
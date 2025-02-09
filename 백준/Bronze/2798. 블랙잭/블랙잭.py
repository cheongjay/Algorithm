def bruteforce(n, m, num):
    max = 0
    for i in range(0, n-2):
        for j in range(i + 1, n-1):
            for k in range(j + 1, n):
                sum = int(num[i]) + int(num[j]) + int(num[k])
                if sum > max and sum <= m:
                    max = sum
    print(max)
                
    

n,m = map(int, input().split())

num = input()

num = num.split()
bruteforce(n,m, num) 
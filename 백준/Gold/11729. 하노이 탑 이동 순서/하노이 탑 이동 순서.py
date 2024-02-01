# 하노이의 탑 백준 11729
# 첫째 줄에 옮긴 횟수 K출력
# 두번째 줄부터 수행과정 출력 1 -> 3

def move(start, end):
    print(start,end)
start = 1
end = 3
via = 2
def hanoi(N,start,end,via):
    if N==1:
        move(start,end)
    else:
        hanoi(N-1,start,via,end)
        move(start,end)
        hanoi(N-1,via,end,start)

N = int(input())
print(2**N-1) #하노이 일반화
hanoi(N,start,end,via)

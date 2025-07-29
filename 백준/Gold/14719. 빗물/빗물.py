h,w=map(int,input().split())
a=list(map(int,input().split()))
left_max=-1
right_max=-1
cnt=0
real_min=-1
for i in range(1,w-1):
    left_max=max(a[:i])
    right_max=max(a[i+1:])
    real_min=min(right_max,left_max)
    if real_min>=a[i]:
        cnt+=(real_min-a[i])
print(cnt)
a = []

for i in range(10):
    N = int(input())
    a.append(N % 42)
s = set(a)
print(len(s))
    
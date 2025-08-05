import sys

input = sys.stdin.readline

T = int(input())

for i in range(T):
    A, B = map(int, input().split(' ')) #map() = 반복 가능한 객체에 대해 각각의 요소들을 지정된 함수로 처리해주는 함수. a,b에 대해 각각 int형으로 형변환을 할 수 있다.
    print( A + B )

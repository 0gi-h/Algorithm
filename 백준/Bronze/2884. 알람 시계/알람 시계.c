#include<stdio.h>
int main(void) {
	int A;
	int B;

	scanf("%d %d", &A, &B);

	if (B >= 45)
	{
		B = B - 45;
	}
	else
	{
		if (A == 0)
		{
			A = 24;
		}
		A = A - 1;
		B = B + 15;
	}
	printf("%d %d", A, B);
}
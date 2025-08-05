#include<stdio.h>
int main(void) {
	
	int A,B,V;
	int total = 0;
	int day = 1;

	scanf("%d %d %d", &A, &B, &V);

	total = (V - A) / (A - B);
	if ((V - A) % (A - B) > 0)
	{
		day += 1;
	}
	else if ((V - A) > 0)
	{
		((V - A) < (A - B)) ? day += 1 : 0;
	}
	
	day += total;
	printf("%d", day);
}
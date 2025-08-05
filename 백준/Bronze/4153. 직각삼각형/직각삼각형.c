#include<stdio.h>
int main(void) {
	
	int a,b,c;
	int MAX;
	int MIN1, MIN2;

	do
	{
		scanf("%d %d %d", &a, &b, &c);

		MAX = (a > b) ? a : b;
		MIN1 = (a < b) ? a : b;
		MIN2 = (MAX < c) ? MAX : c;
		MAX = (MAX > c) ? MAX : c;
		

		if (MAX * MAX == MIN1 * MIN1 + MIN2 * MIN2 && a != 0)
		{
			printf("right\n");
		}
		else if (a != 0)
		{
			printf("wrong\n");
		}

	} while (a != 0 && b != 0 && c != 0);
}
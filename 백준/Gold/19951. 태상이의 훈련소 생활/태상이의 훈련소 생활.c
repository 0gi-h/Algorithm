#define _CRT_SECURE_NO_WARNINGS
#include<stdio.h>

int main(void) {
	int n, m, a, b, k;
	int h[100002] = { 0, };
	int box[100002] = { 0, };
	int sum[100001] = { 0, };

	scanf("%d %d", &n, &m);

	
	for (int i = 1; i <= n; i++)
	{
		scanf("%d", &h[i]);
	}

	for (int i = 0; i < m; i++)
	{
		scanf("%d %d %d", &a, &b, &k);
		box[a] += k;
		box[b + 1] += -k;
	}
	for (int i = 1; i <= n; i++)
	{
		sum[i] = sum[i - 1] + box[i];
	}
	for (int i = 1; i <= n; i++)
	{
		h[i] += sum[i];
		printf("%d ", h[i]);
	}
}		
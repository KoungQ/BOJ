#include <stdio.h>

int main()
{
	int ary[10000];
	int N = 0, X = 0;

	scanf("%d %d", &N, &X);
	for (int i = 0; i < N; i++)
		scanf("%d", &ary[i]);

	for (int i = 0; i < N; i++)
	{
		if (ary[i] < X)
			printf("%d ", ary[i]);		
	}

	return 0;
}
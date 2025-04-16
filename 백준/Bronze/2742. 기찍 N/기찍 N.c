#include <stdio.h>

int main()
{
	int N = 0;

	scanf("%d", &N);

	for (int i = 0; N > i; i++)
		printf("%d\n", N - i);

	return 0;
}
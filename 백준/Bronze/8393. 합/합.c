#include <stdio.h>

int main()
{
	int N = 0;
	int i = 0;

	scanf("%d", &N);

	int save = N;

	for (i = 0; i < N; i++)
		save += i;

	printf("%d", save);

	return 0;
}

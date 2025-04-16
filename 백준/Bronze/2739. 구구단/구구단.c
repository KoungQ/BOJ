#include <stdio.h>

int main()
{
	int input = 0;

	scanf("%d", &input);

	for (int i = 0; i < 9; i++)
		printf("%d * %d = %d\n", input, i + 1, input * (i + 1));

	return 0;
}
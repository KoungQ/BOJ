#include <stdio.h>

int main()
{
	int tmp = 0;
	int cnt = 0;
	int i = 0;
	scanf("%d", &cnt);

	int input[1000] = { 0, };

	for (; i < cnt; i++)
		scanf("%d", &input[i]);

	for (i--; i > 0; i--)
	{
		for (int j = 0; j < i; j++)
		{
			if (input[j] > input[i])
			{
				tmp = input[i];
				input[i] = input[j];
				input[j] = tmp;
			}
		}
	}

	for (int i = 0; i < cnt; i++)
		printf("%d\n", input[i]);

	return 0;
}
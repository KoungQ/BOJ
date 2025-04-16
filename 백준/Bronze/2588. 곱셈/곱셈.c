#include <stdio.h>

int main()
{	
	int input_1 = 0, input_2 = 0;

	scanf("%d %d", &input_1, &input_2);

	printf("%d\n", input_1 * (input_2 % 10));
	printf("%d\n", input_1 * ((input_2 % 100) / 10));
	printf("%d\n", input_1 * (input_2 / 100));
	printf("%d", input_1 * input_2);

	return 0;
}
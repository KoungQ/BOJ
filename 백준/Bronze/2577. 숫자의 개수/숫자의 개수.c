#include <stdio.h>

int main()
{
	int A = 0, B = 0, C = 0;	// input A, B, C
	int intCnt[10] = { 0 };		// count each integers
	int res = 0;	//	'A * B * C' result
	int digit = 0; // input digits 

	scanf("%d\n%d\n%d", &A, &B, &C);	// type each integer to A, B, C

	res = A * B * C;	// type the result

	for (int i = 0; i <= 8; i++)
	{
		if (res == 0)
			break;

		digit = res % 10;
		res /= 10;
		
		intCnt[digit] += 1;
	}

	for (int i = 0; i < 10; i++)	// print all integer to intCnt
		printf("%d\n", intCnt[i]);

	return 0;
}
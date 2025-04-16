#include <stdio.h>

int main()
{
	int a, b;
	scanf("%d %d", &a, &b);
	printf("%.10lf", (double)a / b);
	return 0;
}
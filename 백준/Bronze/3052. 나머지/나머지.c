#include <stdio.h>

int main()
{
	int num[10] = { 0 };	// 10개 입력값
	int restCnt = 0;	// 결과값

	for (int i = 0; i < 10; i++)
		scanf("%d", &num[i]);
	
	for (int i = 0; i < 10; i++)
		num[i] = num[i] % 42;

	for (int i = 0; i < 42; i++)
	{
		for (int j = 0; j < 10; j++)
		{
			if (num[j] == i)
			{
				restCnt++;
				break;
			}
		}
	}
	
	printf("%d", restCnt);

	return 0;
}
#include <stdio.h>

int main()
{
	int count[26] = { 0 };	// 각 알파벳의 개수
	int max = 0;	// 가장 많은 알파벳
	int sec = 0;	// 다음으로 많은 알파벳
	int res_count_1 = 0;	// 가장 많은 알파벳의 개수
	int res_count_2 = 0;	// 다음으로 많은 알파벳의 개수

	char input[1000000] = { 0 };

	scanf("%s", input);

	for (int i = 0; input[i] != '\0'; i++)	// NULL값 까지 반복
	{
		for (int j = 0; j < 26; j++)	// 전체 알파벳을 돌려서 input과 같은 알파벳을 찾고 그 해당 알파벳의 갯수를 +1
		{
			if (input[i] == 'a' + j || input[i] == 'A' + j)
				count[j] += 1;
		}	
	}

	max = count[0];	
	

	for (int i = 1; i < 26; i++)
	{		
		if (max < count[i])	// 수석보다 큰 수가 있다면
		{			
			max = count[i];	// 수석에 새로운 수석을 넣음
			res_count_1 = i;	// 그 수석이 몇번째 알파벳인지 알기 위한 res			
		}
	}
	
	for (int i = 0; i < res_count_1; i++)
	{
		if (max == count[i])	// 만약 가장 많은 알파벳과 다른 알파벳 중에 같은 수가 있다면(max보다 앞번호)
		{
			printf("?");
			return 0;
		}
	}

	for (int i = res_count_1 + 1; i < 26; i++)
	{
		if (max == count[i])	// 만약 가장 많은 알파벳과 다른 알파벳 중에 같은 수가 있다면(max보다 뒷번호)
		{
			printf("?");	// 가장 많은 알파벳이 2개 이상
			return 0;
		}
	}

		printf("%c", 'A' + res_count_1); // 가장 많은 알파벳이 1개
	
	return 0;
}
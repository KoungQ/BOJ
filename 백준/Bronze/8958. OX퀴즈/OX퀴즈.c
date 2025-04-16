#include <stdio.h>

int main()
{
	int num = 0;	// 문제 개수
	int *res;	// 결과값
	char **score;

	scanf("%d", &num);	// 문제 개수 입력받기

	res = (int*)malloc(sizeof(int) * num);
	score = (char*)malloc(sizeof(char*) * num);
	for(int i = 0; i < num; ++i)
		score[i] = (char*)malloc(sizeof(char) * 80);

	for (int i = 0; i < num; i++)	// OX 입력받기
		scanf("%s", score[i]);


	for (int a = 0; a < num; a++)
	{
		int Temp = 0;
		res[a] = 0;
		for (int i = 0; score[a][i] != '\0'; i++)	// OX값이 끝날때까지 돌리기
		{
			if (score[a][i] == 'O')	// 만약 값이 'O'라면
			{
				Temp++;
				res[a] += Temp;
			}
			else
			{
				Temp = 0;
			}
		}
	}

	for (int i = 0; i < num; i++)
		printf("%d\n", res[i]);

	free(res);
	for (int i = 0; i < num; ++i)
		free(score[i]);
	free(score);

	return 0;
}
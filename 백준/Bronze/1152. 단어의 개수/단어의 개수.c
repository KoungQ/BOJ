#include<stdio.h>
#include<string.h>


int main()
{
	char str[1000000];
	int wordCnt = 0;

	gets(str);

	int length = strlen(str);

	for (int i = 0; i < length; i++)
	{
		if (str[i] == ' ')	// 만약 스페이스가 있다면
		{	// 스페이스 앞/뒤에 또 스페이스가 없고,	첫번째 글자가 아니고, 마지막에서 바로 전 문자가 아니라면
			if (str[i - 1] != ' ' && str[i + 1] != ' ' && i != 0 && i != length - 1)
			{
				wordCnt++;	// count +1
			}
			if (length == 1)
			{
				printf("0");
				return 0;
			}
		}
	}

	printf("%d", wordCnt + 1);

	return 0;
}
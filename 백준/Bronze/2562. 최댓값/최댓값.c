#include <stdio.h>

int main()
{
	int max = 0;	// 최댓값 저장할 변수
	int count = 1;	// 최댓값이 몇번째인지 저장할 변수
	int ary[9] = { 0 };	//9개 값 입력받을 배열

	for (int i = 0; i < 9; i++)	//9개 값 입력 받기
		scanf("%d", &ary[i]);

	max = ary[0];	// 첫번째 배열의 값을 max에 저장
	
	for (int i = 1; i < 9; i++)	// 두번째부터 9번째까지 max와 비교
	{
		if (ary[i] > max)	// max보다 크면
		{
			max = ary[i];	// max에 저장하고
			count = i + 1;	// count에 그 값이 몇번째 수인지 저장
		}		
	}
	
	printf("%d\n%d", max, count);	// 출력

	return 0;
}
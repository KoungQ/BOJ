#include <stdio.h>
#include <stdlib.h>
#include <math.h>

double calculation(int size, int flag, double* moneyArr, double avgMoney);

int main() {
	
	int size = 0; 
	while (1) {

		scanf("%d", &size);
		if (size == 0)
			break;

		double student[1001];


		double result = calculation(size, 0, student, 0);
		if (result == -1)
			continue;

		printf("$%.2lf\n", result);
	}

	return 0;
}

double calculation(int size, int flag, double* moneyArr, double avgMoney) {
	if (size == flag) {
		avgMoney = (double)round(avgMoney / size * 100) / 100;

		double resultSum1 = 0;
		double resultSum2 = 0;

		for (int i = 1; i < size + 1; i++) {
			// 평균 금액보다 적은 돈을 냈다면
			if (moneyArr[i] < avgMoney) {
				resultSum1 += (avgMoney - moneyArr[i]);
			}
			else
				resultSum2 += (moneyArr[i] - avgMoney);
		}

		return resultSum1 > resultSum2 ? resultSum2 : resultSum1;
	}

	flag++;

	if (size >= flag) {
		// 금액 받기
		int a;
		scanf("%lf", &moneyArr[flag]);

		if (moneyArr[flag] > 100000) {
			printf("Error : Input Range\n");
			return -1;
		}

		avgMoney += moneyArr[flag];

		// 만약 입력이 잘못됐다면 recursion 중지 main으로 return -1
		double result = calculation(size, flag, moneyArr, avgMoney);
		if (result == -1)
			return -1;
		return result;
	}
}
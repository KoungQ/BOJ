#include <stdio.h>
#include <math.h>

int main() {
	int caseCnt = 0;
	scanf("%d", &caseCnt);

	for (int i = 0; i < caseCnt; i++) {
		int a = 0, b = 0;
		int ret = 1;
		scanf("%d %d", &a, &b);
		
		for (int j = 0; j < b; j++) {
			ret *= a;
			ret %= 10;
		}

		if (ret == 0)
			printf("10\n");
		else
			printf("%d\n", ret);

	} // for (CaseCnt)

	return 0;
}
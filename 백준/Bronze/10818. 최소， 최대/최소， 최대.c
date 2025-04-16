#include <stdio.h>

int main()
{
	int count = 0, max = 0, min = 0;

	scanf("%d", &count);
	for (int i = 0; i < count; i++)
	{
		int integer;
		scanf("%d", &integer);
		if (i == 0)
			max = integer, min = integer;
		else//i!=0
		{
			if (max < integer)
				max = integer;
			if (min > integer)
				min = integer;
		}
	}
	printf("%d %d", min, max);
	return 0;
}
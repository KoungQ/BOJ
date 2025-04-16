#include <stdio.h>
#include <string.h>

typedef struct NODE {
	int data;
	struct NODE* next;
} node;

int topIndex = -1;

void push(node** headRef, int inputNum);
void pop(node** headRef);
void size();
void empty();
void top(node* headRef);

int main()
{
	node* Head = NULL;
	int inputSize = 0;
	char Func_Num[10];

	// 1 <= N <= 10,000 입력
	scanf("%d%*c", &inputSize);

	for (int i = 0; i < inputSize; i++)
	{
		// inputSize 만큼 입력받기
		gets(Func_Num);
		
		// 문자열 자르기 >> Func_에는 함수명, _Num에는 함수 Argument/Parameter.
		char* Func_ = strtok(Func_Num, " ");
		char* _Num = strtok(NULL, " ");
		
		int _NumInt = 0;
		if (_Num != NULL)
			_NumInt = atoi(_Num);
		
		// 입력에 알맞는 함수로 이동
		if (strcmp(Func_, "push") == 0)
			push(&Head, _NumInt);
		else if (strcmp(Func_, "pop") == 0)
			pop(&Head);
		else if (strcmp(Func_, "size") == 0)
			size();
		else if (strcmp(Func_, "empty") == 0)
			empty();
		else if (strcmp(Func_, "top") == 0)
			top(Head);

	}
	

	return 0;
}

void push(node** headRef, int inputNum)
{
	// 새로운 노드 생성
	node* newNode = (node*)malloc(sizeof(node));
	newNode->data = inputNum;
	newNode->next = NULL;

	// 첫 노드라면, 헤드 = 새로운 노드
	if (*headRef == NULL)
		*headRef = newNode;
	// 두번째 이후 노드라면 이어붙이기
	else
	{
		node* tmp = *headRef;

		while (tmp->next != NULL)
			tmp = tmp->next;

		tmp->next = newNode;
	}

	topIndex++;
}

void pop(node** headRef)
{
	// 만약 빈 노드라면, 함수 실행 종료
	if (*headRef == NULL)
	{
		printf("-1\n");
		return;
	}
	// 만약 노드가 한 개 라면, 하나 남은 노드 해제
	else if ((*headRef)->next == NULL)
	{
		node* tmp = *headRef;
		printf("%d\n", tmp->data);
		free(tmp);
		*headRef = NULL;
	}
	// 노드가 두 개 이상 있다면, 마지막 노드 삭제
	else
	{
		node* target = (*headRef)->next;
		node* targetPrev = *headRef;

		while (target->next != NULL)
		{
			target = target->next;
			targetPrev = targetPrev->next;
		}
		
		printf("%d\n", target->data);
		free(target);
		targetPrev->next = NULL;
	}

	topIndex--;
}

void size()
{
	if (topIndex > -1)
		printf("%d\n", topIndex + 1);
	else
		printf("0\n");
}

void empty()
{
	if (topIndex > -1)
		printf("0\n");
	else
		printf("1\n");
}

void top(node* headRef)
{
	if (topIndex == -1)
		printf("-1\n");
	else
	{
		for (int i = 0; i < topIndex; i++)
		{
			headRef = headRef->next;
		}

		printf("%d\n", headRef->data);
	}
}
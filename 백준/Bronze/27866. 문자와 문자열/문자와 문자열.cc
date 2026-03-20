#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{

	char s[1000];
	int i;
	scanf("%s", s);
	scanf("%d", &i);
	printf("%c\n", s[i - 1]);
	return 0;
}
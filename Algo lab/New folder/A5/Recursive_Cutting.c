//Recursive Method for calculating the price
#include<stdio.h>
#include<limits.h>

int max (int a, int b)
{
	return (a > b)? a : b;
}

int rodCutting(int price[], int size)
{
	if (size <= 0)
		return 0;

	int maxLimit = INT_MIN;

	for (int i = 0; i < size; i++)
		maxLimit = max(maxLimit, price[i] + rodCutting(price, size - i - 1));

	return maxLimit;
}

int main()
{
	int size = 0;

	printf("Enter the size of the rod : ");
	scanf("%d", &size);

	int price[size];

    printf("Enter the values of pieces of rod of all size : ");
    for(int i = 0;i < size; i++)
        scanf("%d", &price[i]);

	int maxRevenue = rodCutting(price, size);

	printf("Maximum Obtainable Value is : %d\n", maxRevenue);

	return 0;
}

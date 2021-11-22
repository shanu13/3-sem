#include<stdio.h>
#include<limits.h>

//used bottom to up approach !!!!
int max(int a, int b)
{
    return a > b ? a : b;
}

int rodCutting(int price[], int size)
{
    int result[size + 1];

    result[0] = 0;

    for(int i = 1; i <= size; i++)
    {
        result[i]= INT_MIN;

        for(int j = 0; j < i; j++)
            result[i] = max(result[i], price[j] + result[i - (j + 1)]);
    }

    return result[size];
}

int main()
{
    int size;
    printf("Enter the length of the rod : ");
    scanf("%d", &size);

    int price[size];

    printf("Enter the values of pieces of rod of all size : ");
    for(int i = 0;i < size; i++)
        scanf("%d", &price[i]);

    int maxRevenue = rodCutting(price, size);

    printf("Maximum Revenue : %d\n", maxRevenue);

    return 0;
}

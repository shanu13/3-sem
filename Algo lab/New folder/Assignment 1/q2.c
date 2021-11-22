#include<stdio.h>
#include<stdlib.h>
#include<math.h>

//Bubble sort
void sort(int* a,int n)
{
    int t;
    for(int i=n-1; i>=0; i--)
    {
        for(int j=0; j<i; j++)
        {
            if(a[j]<a[j+1])
            {
                t=a[j];
                a[j]=a[j+1];
                a[j+1]=t;
            }
        }
    }
}

int  main()
{
    int n,min,max=0;
    float t;
    printf("No of integers: \n");
    scanf("%d",&n);
    int* a =(int*)malloc(n*sizeof(int));

    printf("Enter the numbers: \n");
    for(int i=0; i<n; i++)
        scanf("%d",&a[i]);

    sort(a,n);

    // Just to debug the code.
    printf("Inorder traversal of the BST:");
    for(int i=0; i<n; i++)
        printf("%d ",a[i]);
    printf("\n");

    if(n!=0)
        max = n--;

    t=(log2(n*1.0+1));
    min = (int)(t);
    if(min == t)
        min--;
    printf("Max height=%d\nMin height=%d\n",max,min);
}

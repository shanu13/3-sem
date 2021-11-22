#include<stdio.h>
#include<stdlib.h>

int max2(int a,int b)
{
    return a>b ? a:b;
}

int max(int a,int b,int c)
{
    return max2(max2(a,b),c);
}

int maxonbothsides(int a[],int l,int m,int h)
{
    int sum=0;
    int left = -1000;
    for(int i=m;i>=l;i--)
    {
        sum = sum + a[i];
        if(sum > left)
        {
            left = sum;
        }
    }
    sum = 0;
    int right = -1000;
    for(int i=m+1;i<=h;i++)
    {
        sum = sum + a[i];
        if(sum > right)
        {
            right = sum;
        }
    }

    return max(left + right,left,right);
}


int maxsubarray(int a[],int l,int h)
{
    int m=(l+h)/2;
    if(l==h)
    {
        return a[l];
    }

    else
    {

        return max(maxsubarray(a,l,m),maxsubarray(a,m+1,h),maxonbothsides(a,l,m,h));
    }
}


int main()
{
    int a[]={1,2,3,4,5,6,7};
    int maximum = maxsubarray(a,0,6);
    printf("%d",maximum);
}

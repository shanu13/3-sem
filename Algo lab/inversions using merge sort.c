#include<stdio.h>
#include<stdlib.h>


int merge(int a[],int l,int m,int h)
{
    int count=0;
    int n1 = m + 1 -l;
    int n2 = h - m;
    int left[n1];
    int right[n2];
    for(int i=0;i<n1;i++)
    {
        left[i] = a[i +l];
    }
    for(int i=0;i<n2;i++)
    {
        right[i] = a[m  + i + 1];
    }
    int i=0;
    int j=0;
    int k=l;

    while (i < n1 && j < n2) {
        if (left[i] <= right[j]) {
            a[k] = left[i];
            i++;
        }
        else {
            a[k] = right[j];
            count=count + (m-j) ;
            j++;
        }
        k++;
    }

    while (i < n1) {
        a[k] = left[i];
        i++;
        k++;
    }


    while (j < n2) {
        a[k] = right[j];
        j++;
        k++;
    }
    return count;
}


int mergesort(int a[],int l,int h)
{
    int count=0;
    if(l<h)
    {
        int m=(l+h)/2;
        count=mergesort(a,l,m);
        count=count+mergesort(a,m+1,h);
        count=count+merge(a,l,m,h);
    }
    return count;
}



int main(int argv, char** args)
{
    int a[]={1,20,6,4,5,0};
    for(int p=0;p<5;p++)
    {
        printf("%d ",a[p]);
    }
    printf("\n");
    printf("%d\n",mergesort(a,0,5));
    for(int i=0;i<5;i++)
    {
        printf("%d ",a[i]);
    }

}

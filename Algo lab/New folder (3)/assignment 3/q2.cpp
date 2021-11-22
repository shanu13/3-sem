 #include<bits/stdc++.h>
    using namespace std;



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
    int left = INT_MIN;

    for(int i=m;i>=l;i--)
    {
        sum = sum + a[i];
        if(sum > left)
        {
            left = sum;
        }
    }
    sum = 0;
    int right = INT_MIN;
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
    int n;
    cout<<"Enter the value of n"<<endl;
    cin>>n;
    int *a = new int[n];
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    ;
    int maximum = maxsubarray(a,0,n-1);
    cout<<maximum<<endl;
}


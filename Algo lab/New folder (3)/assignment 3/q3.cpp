 #include<bits/stdc++.h>
    using namespace std;



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



int main()
{
    int n;
    cout<<"Enter the value of n"<<endl;
    cin>>n;
    int *a = new int[n];
    for(int i=0; i<n; i++){
        cin>>a[i];
    }
    cout<<"\n";
   cout<<mergesort(a,0,5);
    for(int i=0;i<5;i++)
    {
        cout<<a[i]<<" ";
    }

}


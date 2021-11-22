#include<bits/stdc++.h>


using namespace std;



class PowerOf_X
{
public:
int power(int x,  int n)
{
	if (n == 0)
		return 1;
	else if (n % 2 == 0)
		return power(x, n / 2) * power(x, n/ 2);
	else
		return x * power(x, n / 2) * power(x, n / 2);
}
};

int main()
{
	 PowerOf_X fact;
	 int x,n;
	 cout<<"ENter the value of x"<<endl;
	 cin>>x;
	 cout<<"Enter the value of n"<<endl;
	 cin>>n;

    cout << fact.power(x,n);
	return 0;
}

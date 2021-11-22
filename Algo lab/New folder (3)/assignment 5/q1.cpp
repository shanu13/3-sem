
#include<bits/stdc++.h>
    using namespace std;



int max (int a, int b)
{
	return (a > b)? a : b;
}

int rodCutting(int *price, int size)
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

	cout<<"Enter the size of the rod : ";
	cin>>size;

	int price[size];

    cout<<"Enter the price of pieces of rod of all size : ";
    for(int i = 0;i < size; i++)
       cin>>price[i];
	int maxRevenue = rodCutting(price, size);

	cout<<"Maximum Obtainable Value is  "<< maxRevenue;

	return 0;
}

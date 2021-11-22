#include<bits/stdc++.h>
    using namespace std;





int max (int x, int y)
{
	return x > y ? x : y;
}

void initRod(int *rod, int size)
{
	rod[0] = 0;

	for(int i = 1; i <= size; i++)
		rod[i] = INT_MIN;
}

int rodCutting(int *rod, int price[], int n)
{
	if (rod[n] >= 0)
		return rod[n];

	int maxProfit = INT_MIN;

	for(int i = 1; i <= n; i++)
		maxProfit = max(maxProfit, price[i - 1] + rodCutting(rod, price, n-i));

	rod[n] = maxProfit;
	return rod[n];
}

int main() {
	int size = 0;

	cout<<"Enter the size of rod : ";
	cin>>size;;
	int rod[size];

	initRod(rod, size);

	int price[size];

    cout<<"Enter the values of pieces of rod of all size : ";
    for(int i = 0;i < size; i++)
        cin>>price[i];

    int maxRevenue = rodCutting(rod, price, size);

	cout<<"Maximum Revenue generated : "<<maxRevenue;

	return 0;
}

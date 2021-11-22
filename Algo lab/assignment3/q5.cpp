#include<bits/stdc++.h>
    using namespace std;

    int multiplication(int X, int Y)
{
    string x = to_string(X);
    string y = to_string(Y);
    int result = 0;

    for (int i = 0; i < y.length(); i++)
    {
        int carry = 0;
        string inter_res = "";

        // Looping over x.
        for (int j = x.length() - 1; j >= 0; j--)
        {

            int num = (y[i] - '0') * (x[j] - '0') + carry;

            if (num > 9 && j > 0)
            {
                inter_res = to_string(num % 10) + inter_res;
                carry = num / 10;
            }

            else
            {
                inter_res = to_string(num) + inter_res;
                carry = 0;
            }
        }


        result *= 10;
        result += stoi(inter_res);
    }
    return result;
}
int main()
{
    cout << multiplication(12, 5);
}

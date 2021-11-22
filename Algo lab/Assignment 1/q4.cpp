#include<bits/stdc++.h>
using namespace std;
string add(string s , string t)
{
    string p ="";
    int i = s.length()-1,j=t.length()-1;

    int c = 0;

    while(i>=0&&j>=0){
        int si = s[i] - '0';
        int tj = t[j] - '0';

        int sum = si + tj + c;
        c = sum/10;

        sum = sum%10;

        char v = (sum+'0');

        p = v + p;

        i--;
        j--;


    }



    while(i>=0)
    {
         int si = s[i] - '0';

         int sum = si + c;
          c = sum/10;

        sum = sum%10;

         char v = (sum+'0');

        p = v + p;

        i--;
    }

    while(j>=0)
    {
        int tj = t[j] - '0';

        int sum = tj + c;

        c = sum/10;

        sum = sum%10;

        char v = (sum+'0');
        p = v + p;

        j--;
    }
    if(c!=0)
    {
        char v = c + '0';

        p = v + p;

    }

    return p;

}
int main()
{
    string s,t;
    cout<<"Enter first Integer : ";
    cin >> s;
    cout<<"Enter second Integer : ";
    cin >> t;


    cout << add(s,t) << endl;
}




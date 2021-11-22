#include<bits/stdc++.h>
using namespace std;
string add(string s , string t )
{
    string p ="";
    int i = s.length()-1,j=t.length()-1;

   int c = 0;

    while(i>=0&&j>=0)
    {

        if(s[i]==t[j]&&s[i]=='.')
        {
            i--;
            j--;
            p = '.' + p;
            continue;
        }
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
    printf("Enter the real value_1 : ");
    cin >> s ;
    printf("Enter the real value_2 : ");
    cin >> t;

    if(s.find('.')==-1)
    {
        s = s + ".0";

    }
    if(t.find('.')==-1)
    {
        t = t + ".0";

    }



    int ls = s.length()-s.find('.');
    int lt = t.length()-t.find('.');
    if(ls>lt)
    {
        while(lt!=ls)
        {
            t = t + '0';
            lt++;
        }
    }
    else
    {
        while(ls!=lt)
        {
           s = s + '0';
           ls++;
        }
    }

    int c = 0;


    string final_answer = add(s,t);





    cout << final_answer << endl ;



}





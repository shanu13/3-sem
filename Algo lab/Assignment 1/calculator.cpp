
#include<iostream>
#include<algorithm>

using namespace std;


int main(){
    bool flag = true;
    double a,b;
    int choice;

        cout<<"Press 1 for addition : "<<"\n"<<"Press 2 for substraction"<< "\n"<<"Press 3 for Multiplication"<<"\n"<< "Press 4 for Division"<<"\n"<<"Press 5 for exit"<<"\n";

        cin>>choice;
        switch(choice){
            case 1:
             cout<<"Enter two numbers"<<"\n";
             cin>>a>>b;
             cout<<a+b<<"\n";
             break;

           case 2:
            cout<<"Enter two numbers"<<"\n";
             cin>>a>>b;
             cout<<a-b<<"\n";
              break;

             case 3:
              cout<<"Enter two numbers"<<"\n";
             cin>>a>>b;
             cout<<a*b<<"\n";
              break;

             case 4:
             cout<<"Enter two numbers"<<"\n";
             cin>>a>>b;
             cout<<a/b<<"\n";
              break;


             case 5:
                flag = false;
                 break;

        }




    return 0;
}

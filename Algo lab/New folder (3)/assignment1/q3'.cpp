  #include<bits/stdc++.h>
    using namespace std;


int main(){

  int n,Min=0,Max=0,t;

  cout<<"Enter no of nodes in AVL trees: ";
  cin>>n;

  if(n!=0){
    t=(log2(n*1.0+1));
    Min =(int)(t);
    if(Min == t)
      Min--;
    Max =(int)(1.44*log2(n*1.0));
  }
  cout<<"Height for Min nodes is from "<<Min " to " <<Min+1;
  cout<<"Height for Max nodes is from "<<Max<<" to "<<Max+1;
}


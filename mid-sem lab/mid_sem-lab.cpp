#include<iostream>
#include<fstream>
#include<algorithm>
using namespace std;

int main(int argc, char*argv[]){
cout<<"Content of input file : "<<"\n";
 ifstream input(argv[1]);
 int no_spaceships = argv[0];
 double length_spaceships = new fouble[no_spaceships];
  for(int i=1; i<argc; i++){
    double[i-1] = argv[i];
    cout<<double[i]<<"\n";
  }
}

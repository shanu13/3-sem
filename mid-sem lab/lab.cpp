#include<bits/stdc++.h>
using namespace std;


double MaximumTime(int n, double* length){
  double nums[n + 2];
    int k = 1;

    for (int index =0; index<n; index++)
    {if (length[index] > 0)
     nums[k++] = length[index];
    }
    nums[0] = nums[k++] = 0;


    double dp_array[n][n] = {};
    for (int i = 2; i < n; ++i)
       {
        for (int left = 0; left < k - i; ++left)
        {   int right = left + i;
            for (int j = left + 1; j < right; ++j)
            dp_array[left][right] = max(dp_array[left][right], nums[left]/2.0 + nums[j] + nums[right]/2 + dp_array[left][j] + dp_array[j][right]);
        }
       }

    return dp_array[0][k - 1];
}


int main(int argc, char*argv[]){
cout<<"Content of input file : "<<" ";
 ifstream input(argv[1]);
int no_spaceships;
input>>no_spaceships;
double *length_spaceships = new double[no_spaceships];
 for(int i=0; i<no_spaceships; i++){
        input>>length_spaceships[i];
 }
 for(int i=0; i<no_spaceships; i++ ){
    cout<<setprecision(10)<<length_spaceships[i]<<" , ";
 }
 cout<<"\n";
double time =  MaximumTime(no_spaceships,length_spaceships);
input.close();
ofstream output("output.txt");
output<<time;
 cout<<time<<"\n";
  }


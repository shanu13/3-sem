#include<stdio.h>
#include<math.h>

int main(){

  int n,min=0,max=0,t;

  printf("Enter no of nodes in AVL trees: ");
  scanf("%d",&n);

  if(n!=0){
    t=(log2(n*1.0+1));
    min =(int)(t);
    if(min == t)
      min--;
    max =(int)(1.44*log2(n*1.0));
  }
  printf("Height for min nodes is from %d to %d.\n",min,min+1);
  printf("Height for max nodes is from %d to %d.\n",max,max+1);
}

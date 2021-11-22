#include<stdio.h>
#include<stdlib.h>
#include<string.h>

void main(){
  int n1,n2,nf,nl,carry=0,dig=0;

  printf("Enter the number of digits in the 1st & 2nd +ve integer\n");
  scanf("%d",&n1);
  scanf("%d",&n2);
  printf("%d %d\n",n1,n2);

  nf=(n1>n2)?n1:n2;
  nl=(n1>n2)?n1:n2;

  char* int1=(char*)calloc(n1,sizeof(char));
  char* int2=(char*)calloc(n2,sizeof(char));
  char* intf=(char*)calloc(nf,sizeof(char));
  printf("Enter the 2 numbers in the order as their length were given above:\n");
  scanf("%s",int1);
  scanf("%s",int2);

  for(int i=1;i<=nf;i++){
      if(i<=n1)dig+=int1[n1-i]-48;
      if(i<=n2)dig+=int2[n2-i]-48;
      dig+=carry;
      carry=dig/10;
      dig=dig%10;
      intf[nf-i]=dig+48;
      dig=0;
      if(i>nl && carry==0)
        break;
  }
  if(carry!=0)
    printf("%d",carry);
  printf("%s\n",intf);
}

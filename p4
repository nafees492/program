#include <stdio.h>




void subset(int str[],int n,int r,int index,int data[],int i)
{
    if(index==r){
       for(int j=0;j<r;j++)
    {
        printf("%d",data[j]);
    }
        printf("\n");

    
    return;
    }
if(i>=n)
return;
data[index]=str[i];
subset(str,n,r,index+1,data,i+1);
subset(str,n,r,index,data,i+1);
}



int main()
{
  int str[5];
  for(int i=0;i<5;i++)
  {
      scanf("%d",&str[i]);
  }

    int n=sizeof(str)/sizeof(str[0]);

    int r=3;
    int data[r];
    subset(str,n,r,0,data,0);

}

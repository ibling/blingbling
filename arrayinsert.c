#include<stdio.h>
int main()
{
   int a[1000],n,i,j;
   scanf("%d",&n);
   for(i=0;i<n;i++)
   {
	   scanf("%d",&a[i]);
   }
   for(i=1;i<n;i++)
   {
      if(a[i-1]>a[i])
	  {
	     int temp=a[i];
		 j=i;
		 while(j>0&&a[j-1]>temp)
		 {
			 a[j]=a[j-1];
			 j--;
		 }
		 a[j]=temp;
	  }
   }
   for(i=0;i<n;i++)
   {
      printf("%d ",a[i]);
   }
   return 0;
}

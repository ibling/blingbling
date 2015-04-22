#include<mex.h>

#include<stdio.h>

#inlcude<math.h>

double f(double x)

{

   return sin(x)/x;

}

double intergral(double a,double b)

{

    double t=1.0/(2.0)^8;

    double sum=0.0;

    for(int x=a;x<b;x+=t)

    {

       sum+=(t/6.0)*(f(x)+4*f(x+t/2.0)+f(x+t));

    }

    return sum;

}

void mexFunction(int nlhs,mxArray *plhs[],int nrhs,const mxArray *prhs[] )

{

   double *intf;

   double a,b;

   plhs[0] = mxCreatDouleMatrix(1,1,mxREAL);

   intf = mxGetPr(plhs[0]);

   a = *(mxGetPr(prhs[0]));

   b = *(mxGetPr(prhs[1]));

   *a = intergral(a,b);

}

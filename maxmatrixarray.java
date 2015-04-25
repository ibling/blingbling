
package javaapplication1;

import java.util.Scanner;

public class JavaApplication1{

    public static void main(String[] args) {

        Scanner input =  new Scanner(System.in);

        System.out.println("Please input the order of the matrix:");

        int n = input.nextInt();

        int [][]a = new int [n+1][n+1];

        System.out.println("Please input the n*n matrix:");

        for (int i = 1;i<=n;i++)

            for(int j = 1;j<=n;j++)

               a[i][j] = input.nextInt();

        int []b = findLargestBlock(a);

        System.out.println("最大子方阵位于（"+b[0]+"，"+b[1]+") 阶数"+b[2]);

    }

    public static int[] findLargestBlock(int [][] m){

        int [] info = new int [3];

        int [][] dp = new int [m.length][m.length];

        for ( int i = 0;i<m.length;i++)

            for( int j = 0;j<m.length;j++)

                 dp [i][j] =0;

        info[0] = 1;

        info[1] = 1;

        info[2] = 1;

        int min = 0;

        int maxn = 0;

        int x = 0,y =0;

        for (int i = 1;i<m.length;i++) {

            for (int j = 1;j<m.length;j++) {

                if(m[i][j] == 0)

                    dp[i][j]=0;

                else {

                    min = m.length;

                    if(i-1>=0&&dp[i-1][j]<min) min = dp[i-1][j];

                    if(j-1>=0&&dp[i][j-1]<min) min = dp[i][j-1];

                    if(i-1>=0&&j-1>0&&dp[i-1][j-1]<min) min = dp[i-1][j-1];

                    if(min+1>maxn){

                         maxn = min+1;

                         x = i;

                         y = j;

                    }

                    dp[i][j] = min+1;

                }

                info [0] = x-maxn;

                info [1] = y-maxn;

                info [2] = maxn;

            }

        }

        return info; 

    }

}

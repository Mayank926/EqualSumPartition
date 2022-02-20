package algos.dp.EqualSumSubset;

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);

            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static boolean t[][];
    static int equalPartition(int N, int arr[])
    {
        int sum = 0;
        for(int element :arr)
            sum+=element;
        if(sum%2!=0)
            return 0;
        int sumOfSubset=sum/2;
        t = new boolean[N+1][sumOfSubset+1];
        for(int i=0;i<N+1;i++){
            t[i][0]=true;
            for(int j=0;j<sumOfSubset+1;j++){
                if(i==0){
                    if(j!=0)
                        t[i][j]=false;
                    continue;
                }
                int origIdx=i-1;
                if(arr[origIdx]<=j){
                    t[i][j]=t[origIdx][j-arr[origIdx]] || t[origIdx][j];
                }else{
                    t[i][j]=t[origIdx][j];
                }
                if(j==sumOfSubset && t[i][j])
                    return 1;
            }
        }
        return 0;
    }
}

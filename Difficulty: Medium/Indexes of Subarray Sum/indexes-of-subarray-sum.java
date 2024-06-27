//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main{
	static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);

        int t = Integer.parseInt(br.readLine());

        while(t-->0){
            
            String s[] = br.readLine().trim().split(" ");
            
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);
            int a[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(a, n, k);
            for(int ii = 0;ii<res.size();ii++)
                ot.print(res.get(ii) + " ");
            ot.println();
        }
        ot.close();
    }

}
// } Driver Code Ends


class Solution
{
    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s) 
    {
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        int l = 0, r = 0;
        int sum = 0;
        
        // Edge case when s is 0
        if (s == 0) {
            for (int i = 0; i < n; i++) {
                if (arr[i] == 0) {
                    ans.add(i + 1); // 1-based index
                    ans.add(i + 1); // 1-based index
                    return ans;
                }
            }
            ans.add(-1); // No subarray found
            return ans;
        }
        
        while (r < n) {
            sum += arr[r];
            
            while (sum > s && l <= r) {
                sum -= arr[l];
                l++;
            }
            
            if (sum == s) {
                ans.add(l + 1); // 1-based index for left
                ans.add(r + 1); // 1-based index for right
                return ans;
            }
            
            r++;
        }
        
        ans.add(-1); // No subarray found
        return ans;
    }
}
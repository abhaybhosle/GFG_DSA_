//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(read.readLine().trim());
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr, n));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    String longestCommonPrefix(String arr[], int n){
        // code here
        if (n == 0) {
            return "-1";
        }
        
        // Find the shortest string in the array
        String minStr = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i].length() < minStr.length()) {
                minStr = arr[i];
            }
        }
        
        // Use the shortest string to find the common prefix
        StringBuilder prefix = new StringBuilder();
        
        outer:
        for (int i = 0; i < minStr.length(); i++) {
            char currentChar = minStr.charAt(i);
            for (int j = 0; j < n; j++) {
                if (arr[j].charAt(i) != currentChar) {
                    break outer; // No need to check further
                }
            }
            prefix.append(currentChar);
        }
        
        return prefix.length() == 0 ? "-1" : prefix.toString();
    }
}
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
class GFG {
    public static void main(String[] args) {

        // Taking input using class Scanner
        Scanner sc = new Scanner(System.in);

        // Taking total count of testcases
        int t = sc.nextInt();

        while (t-- > 0) {
            // taking total count of elements
            int n = sc.nextInt();

            // creating a new array of size n
            int arr[] = new int[n];

            // inserting elements to the array
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            // calling firstRepeated method
            // and printing the result
            System.out.println(ob.firstRepeated(arr, n));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to return the position of the first repeating element.
    public static int firstRepeated(int[] arr, int n) {
        // Your code here
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Variable to store the result
        int minIndex = Integer.MAX_VALUE;
        
        // Traverse the array
        for (int i = 0; i < n; i++) {
            // Check if the element already exists in the map
            if (map.containsKey(arr[i])) {
                // Update minIndex if this element's index is smaller
                minIndex = Math.min(minIndex, map.get(arr[i]));
            } else {
                // Store the element with its index in the map
                map.put(arr[i], i + 1); // Using 1-based indexing
            }
        }
        
        // If minIndex was updated, return it; otherwise, return -1
        return minIndex == Integer.MAX_VALUE ? -1 : minIndex; 
    }
}

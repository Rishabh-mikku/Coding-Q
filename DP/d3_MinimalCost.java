// There are n stones and an array of heights and Geek is standing at stone 1 and can jump to one of the following: Stone i+1, i+2, ... i+k stone and cost will be [hi-hj] is incurred, where j is the stone to land on. Find the minimum possible total cost incurred before the Geek reaches Stone N.

// Example 1:
// Input:
// n = 5, k = 3
// heights = {10, 30, 40, 50, 20}
// Output:
// 30
// Explanation:
// Geek will follow the path 1->2->5, the total cost 
// would be | 10-30| + |30-20| = 30, which is minimum
// Example 2:

// Input:
// n = 3, k = 1
// heights = {10,20,10}
// Output:
// 20
// Explanation:
// Geek will follow the path 1->2->3, the total cost
// would be |10 - 20| + |20 - 10| = 20.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function minimizeCost() which takes the array height, and integer n, and integer k and returns the minimum energy that is lost.

// Expected Time Complexity: O(n*k)
// Expected Space Complexity: O(n)

// Constraint:
// 2 <= n <= 105
// 1 <= k <= 100
// 1 <= heights[i] <= 104

import java.util.Arrays;

public class d3_MinimalCost {

    public static int minCost(int[] arr, int n, int k) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);

        // return minCostSolve(n-1, arr, n, k, dp);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int idx=1;idx<n;idx++) {
            int min_steps = Integer.MAX_VALUE;
            for(int i=1;i<=k;i++) {
                if(idx-i >= 0) {
                    int jump = dp[idx-i] + Math.abs(arr[idx] - arr[idx-i]);
                    min_steps = Math.min(min_steps, jump);
                }
            }

            dp[idx] = min_steps;
        }

        return dp[n-1];
    }

    public static int minCostSolve(int idx, int[] arr, int n, int k, int[] dp) {
        if(idx == 0)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];
        
        int min_steps = Integer.MAX_VALUE;
        for(int i=1;i<=k;i++) {
            if(idx-i >= 0) {
                int jump = minCostSolve(idx-i, arr, n, k, dp) + Math.abs(arr[idx] - arr[idx-i]);
                min_steps = Math.min(min_steps, jump);
            }
        }

        return dp[idx] = min_steps;
    }
    public static void main(String[] args) {
        int n=5, k=3;
        int[] heights = {10, 30, 40, 50, 20};
        System.out.println(minCost(heights, n, k));
    }
}

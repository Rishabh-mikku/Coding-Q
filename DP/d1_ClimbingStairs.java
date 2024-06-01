// You are climbing a staircase. It takes n steps to reach the top.

// Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 

// Example 1:

// Input: n = 2
// Output: 2
// Explanation: There are two ways to climb to the top.
// 1. 1 step + 1 step
// 2. 2 steps
// Example 2:

// Input: n = 3
// Output: 3
// Explanation: There are three ways to climb to the top.
// 1. 1 step + 1 step + 1 step
// 2. 1 step + 2 steps
// 3. 2 steps + 1 step
 

// Constraints:

// 1 <= n <= 45


import java.util.Arrays;
public class d1_ClimbingStairs {

    public static int climbStairs(int n) {
        // int dp[] = new int[n+1];
        // Arrays.fill(dp, -1);

        // return climbStairsSolve(n, dp);

        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;

        for(int idx=2;idx<=n;idx++) {
            dp[idx] = dp[idx-1] + dp[idx-2];
        }

        return dp[n];
    }

    public static int climbStairsSolve(int idx, int dp[]){
        if (idx == 0)
            return 1;
        
        if (dp[idx] != -1)  return dp[idx];

        int one_step = climbStairsSolve(idx-1, dp);
        int two_step = 0;
        if (idx >= 2) {
            two_step = climbStairsSolve(idx-2, dp);
        }

        return dp[idx] = one_step + two_step;
    }
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairs(n));
    }
}
// Geek wants to climb from the 0th stair to the (n-1)th stair. At a time the Geek can climb either one or two steps. A height[N] array is also given. Whenever the geek jumps from stair i to stair j, the energy consumed in the jump is abs(height[i]- height[j]), where abs() means the absolute difference. return the minimum energy that can be used by the Geek to jump from stair 0 to stair N-1.

// Example:
// Input:
// n = 4
// height = {10 20 30 10}
// Output:
// 20
// Explanation:
// Geek jump from 1st to 2nd stair(|20-10| = 10 energy lost).
// Then a jump from the 2nd to the last stair(|10-20| = 10 energy lost).
// so, total energy lost is 20 which is the minimum.
// Your Task:
// You don't need to read input or print anything. Your task is to complete the function MinimumEnergy() which takes the array height, and integer n, and returns the minimum energy that is lost.

// Expected Time Complexity: O(n)
// Expected Space Complexity: O(n)

// Constraint:
// 1<=n<=100000
// 1<=height[i]<=1000

import java.util.Arrays;

public class d2_GeekJump {

    public static int geekJump(int n, int[] arr) {
        // int[] dp = new int[n];
        // Arrays.fill(dp, -1);

        // return geekJumpSolve(n-1, arr, dp);

        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for(int idx=1;idx<n;idx++) {
            int two_step = Integer.MAX_VALUE;
            int one_step = dp[idx-1] + Math.abs(arr[idx] - arr[idx-1]);
            if(idx >= 2) {
                two_step = dp[idx-2] + Math.abs(arr[idx] - arr[idx-2]);
            }

            dp[idx] = Math.min(one_step, two_step);
        }q

        return dp[n-1];
    }

    public static int geekJumpSolve(int idx, int[] arr, int[] dp) {
        if(idx == 0)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];
        
        int one_step = geekJumpSolve(idx-1, arr, dp) + Math.abs(arr[idx] - arr[idx-1]);
        int two_step = Integer.MAX_VALUE;
        if(idx >= 2) {
            two_step = geekJumpSolve(idx-2, arr, dp) + Math.abs(arr[idx] - arr[idx-2]);
        }

        return dp[idx] = Math.min(one_step, two_step);
    }
    public static void main(String[] args) {
        int n = 4;
        int[] height = {10, 20, 30, 10};

        System.out.println(geekJump(n, height));
    }
}

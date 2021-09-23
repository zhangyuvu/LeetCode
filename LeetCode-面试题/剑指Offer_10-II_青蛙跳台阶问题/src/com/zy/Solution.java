package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/22 15:58
    一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

    示例 1：

    输入：n = 2
    输出：2
    示例 2：

    输入：n = 7
    输出：21
    示例 3：

    输入：n = 0
    输出：1
    提示：

    0 <= n <= 100


 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(numWays(400));
    }

    /*
        定义状态 dp[i] 是 i 个台阶会有多少种跳法
        边界条件： dp[0] = 1 dp[1] = 1
        状态转移方程 dp[i] = dp[i-1] + dp[i - 2]
        因为跳 1 步到达终点是一种跳法 跳 2 步到达终点也是一种跳法 总共就这两种跳法 加起来就是总共的跳法了
     */
    public static int numWays(int n) {
        if(n == 0 || n == 1){
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[0] = 1;  // 定义边界
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }
}

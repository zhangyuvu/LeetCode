package com.zy;

import java.util.Arrays;

/**
 * @author zhangyu
 * @date 2021/9/23 14:50
    给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。

    计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。

    你可以认为每种硬币的数量是无限的。

    示例 1：

    输入：coins = [1, 2, 5], amount = 11
    输出：3
    解释：11 = 5 + 5 + 1
    示例 2：

    输入：coins = [2], amount = 3
    输出：-1
    示例 3：

    输入：coins = [1], amount = 0
    输出：0
    示例 4：

    输入：coins = [1], amount = 1
    输出：1

    示例 5：

    输入：coins = [1], amount = 2
    输出：2
     

    提示：

    1 <= coins.length <= 12
    1 <= coins[i] <= 231 - 1
    0 <= amount <= 104


 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(coinChange(new int[]{2,4},1));

    }


    /*
        定义状态 dp[i]是 总金额为 i 的情况下 需要的最少硬币数量
        初始值 i = 0 的时候需要0个硬币
        状态转移方程  dp[i] = min(dp[i - coin]) + 1  coin ∈ coins
        dp[i]中 i 尝试减去每一个硬币的面值， 设每次减去一个硬币面值之后的值为 j ，变量 j = i - coin 0 <= j < i
        由于硬币有多个 所以 j 的值也在变化 ,由于要求最少的硬币数量，所以从所有 dp[j] 中取出硬币数量最少的加一 得出的就是 dp[i]
        因为从 j 这个金额到 i 这个金额 只需要 1 枚硬币就够了  dp[i] = min(dp[j]) + 1  j = i - coin
     */
    public static int coinChange(int[] coins, int amount) {
        if(amount == 0){
            return 0;
        }
        int[] dp = new int[amount + 1];  // 状态

        for (int i = 1; i < dp.length; i++){
            dp[i] = Integer.MAX_VALUE - 1;
            for (int coin : coins) {
                if(i >= coin){
                    dp[i] = Math.min(dp[i - coin] + 1 , dp[i]);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }
}

package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/25 22:42

    在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

    示例 1:

    输入:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    输出: 12
    解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
     
    提示：

    0 < grid.length <= 200
    0 < grid[0].length <= 200

 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(maxValue(new int[][]{{1,3,1},{1,5,1},{4,2,1}}));
    }

    /*
        初始化第一行和第一列   这中优化方式提升很大  时间从超过48% 直接到98% 内存从超过40% 直接到 81%
     */
    public static int maxValue2(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 1; i < n; i++){
            grid[i][0] += grid[i-1][0];
        }
        for (int i = 1; i < m; i++){
            grid[0][i] += grid[0][i-1];
        }

        for(int i = 1; i < n; i++){
            for (int j = 1; j < m; j++){
                grid[i][j] = Math.max(grid[i][j - 1],grid[i - 1][j]) + grid[i][j];
            }
        }

        return grid[n-1][m - 1];
    }
    /*
        相较于最下面的动态规划原版 没有优化提升...
     */
    public static int maxValue1(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for(int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if(i == 0 && j == 0) continue;
                if(j == 0){
                    grid[i][j] = grid[i-1][j] + grid[i][j];
                    continue;
                }
                if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                    continue;
                }
                grid[i][j] = Math.max(grid[i][j - 1],grid[i - 1][j]) + grid[i][j];
            }
        }

        return grid[n-1][m - 1];
    }

    /*
            定义状态 dp(i,j) 为 走到 i 行 j 列时 可获得最多价值的礼物
            dp(i , j - 1) 为走到 dp(i,j) 左边获得的礼物价值

            dp(i - 1, j) 为 走到 dp(i,j) 上面边获得的礼物价值

            状态转移方程  dp(i,j) = max(dp(i , j - 1) + dp(i - 1, j)) + grid(i,j)

    */
    public static int maxValue(int[][] grid) {

        int[][] dp = new int[grid.length + 1][grid[0].length + 1];

        for(int i = 1; i <= grid.length; i++){
            for (int j = 1; j <= grid[0].length; j++){
                dp[i][j] = Math.max(dp[i][j - 1],dp[i - 1][j]) + grid[i-1][j-1];
            }
        }

        return dp[grid.length][grid[0].length];
    }

}

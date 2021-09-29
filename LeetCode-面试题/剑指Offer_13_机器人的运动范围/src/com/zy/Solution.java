package com.zy;

import java.util.Scanner;

/**
 * @author zhangyu
 * @date 2021/9/28 18:16
    地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
    它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
    例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。
    请问该机器人能够到达多少个格子？

    示例 1：

    输入：m = 2, n = 3, k = 1
    输出：3
    示例 2：

    输入：m = 3, n = 1, k = 0
    输出：1
    提示：

    1 <= n,m <= 100
    0 <= k <= 20



 */
public class Solution {
    public static void main(String[] args) {

    }

    public int movingCount(int m, int n, int k) {
        if( k == 0) return 1;
        if(m == 1 && n == 1) return 1;

        int max = 1;
        boolean[][] via = new boolean[m][n];  // 用来保存 i 行 j 列的元素是否可以达到
        via[0][0] = true;

        // 初始化边界
        for(int i = 1; i < m; i++){
            if(getSum(i) <= k){
                via[i][0] = true;
                max++;
            }else {
                break;
            }
        }
        for(int i = 1; i < n; i++){
            if(getSum(i) <= k){
                via[0][i] = true;
                max++;
            }else {
                break;
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++){
                if(getSum(i) + getSum(j) > k ) continue;

                // 来到这里 代表符合小于 K 的要求 剩下的就是看是否能到达了
                // 只要上面或者左边有一个能到达 就能到达这个位置
                via[i][j] = via[i -1][j] | via[i][j-1];

                max +=  via[i][j] ? 1 : 0 ;
            }
        }

        return max;
    }

    int getSum(int num){
        int res = num % 10;
        res += num / 10;
        return res;
    }



}

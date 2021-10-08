package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/25 16:48
    给定两个单词 word1 和 word2，找到使得 word1 和 word2 相同所需的最小步数，每步可以删除任意一个字符串中的一个字符。

    示例：

    输入: "sea", "eat"
    输出: 2
    解释: 第一步将"sea"变为"ea"，第二步将"eat"变为"ea"
     
    提示：

    给定单词的长度不超过500。
    给定单词中的字符只含有小写字母。

    可转换为最长公共子序列的问题
 */


public class Solution {

    // 此题可以当作最长公共子序列来完成
    // 定义状态 dp( i , j ) 为 序列1到 i-1 位置和序列2到 j-1 位置时的 最长公共子序列长度

    // 初始化 dp (i,0) dp(0,j) 的最长公共子序列都是0

    // 状态转移方程
    // 当 word1[i-1] = word2[j-1] 时  dp(i,j) = dp(i-1,j-1) + 1
    // 如果不相等  则 dp(i,j) = max( dp(i,j-1), dp(i-1,j) )   因为 可能存在 word1[i] = word2[j-1] 或者 word1[i-1] = word2[j]


    // 这种写法速度 更快 内存占用更小
    public int minDistance(String word1, String word2) {
        if(word1 == null || word1.length() == 0 ||
                word2 == null || word2.length() == 0){
            return 0;
        }

        char[] chars1 = word1.toCharArray();
        char[] chars2 = word2.toCharArray();
        char[] cols = chars2, rows = chars1;
        if( cols.length > rows.length){
            cols = chars1;
            rows = chars2;
        }

        int[] dp = new int[cols.length + 1];

        for (int rowNum = 1; rowNum <= rows.length; rowNum++){
            int cur = 0;
            for (int colNum = 1; colNum <= cols.length; colNum++) {
                int leftTop = cur;
                cur = dp[colNum];
                if(rows[rowNum - 1] == cols[colNum - 1]){
                    dp[colNum] = leftTop + 1;
                }else {
                    dp[colNum] = Math.max(dp[colNum - 1],dp[colNum]);
                }
            }
        }

        return (cols.length - dp[cols.length]) + (rows.length - dp[cols.length]);
    }


    public int minDistance1(String word1, String word2) {
        if(word1 == null || word1.length() == 0 ||
                word2 == null || word2.length() == 0){
            return 0;
        }

        String cols = word1, rows = word2;
        if( cols.length() > rows.length()){
            cols = word2;
            rows = word1;
        }
        int length = cols.length() ;
        int[] dp = new int[length + 1];

        for (int rowNum = 1; rowNum <= rows.length(); rowNum++){
            int cur = 0;
            for (int colNum = 1; colNum <= length; colNum++) {
                int leftTop = cur;
                cur = dp[colNum];
                if(rows.charAt(rowNum - 1) == cols.charAt(colNum - 1)){
                    dp[colNum] = leftTop + 1;
                }else {
                    dp[colNum] = Math.max(dp[colNum - 1],dp[colNum]);
                }
            }
        }

        return (length - dp[length]) + (rows.length() - dp[length]);
    }



}

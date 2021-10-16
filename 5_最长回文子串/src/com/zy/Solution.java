package com.zy;

/**
 * @author zhangyu
 * @date 2021/10/16 19:36

    给你一个字符串 s，找到 s 中最长的回文子串。

    示例 1：

    输入：s = "babad"
    输出："bab"
    解释："aba" 同样是符合题意的答案。
    示例 2：

    输入：s = "cbbd"
    输出："bb"
    示例 3：

    输入：s = "a"
    输出："a"
    示例 4：

    输入：s = "ac"
    输出："a"
     

    提示：

    1 <= s.length <= 1000
    s 仅由数字和英文字母（大写和/或小写）组成
 */
public class Solution {

    public static void main(String[] args) {
        String s = "123";
        System.out.println(s.substring(0,3));
    }

    /*
        动态规划解题
        定义状态 dp[i][j] 为 字符串 s 中 i 和 j 这个闭区间的子串是否是回文串
        初始化值 当 i = j时，dp[i][j] 为 true  （闭区间，charAt(i) = charAt(j) ）


        当 i <= j 时 ， 有状态转移方程
        当 j - i < 3 时 此时 区间 [i,j] 中的元素个数最多为 3 个 所以 dp（i,j) = charAt(i) == charAt(j)
        当 j - i >= 3 时 此时  dp(i,j) = charAt(i) == charAt(j) && dp(i + 1, j - 1)
        可以这样理解 只有当charAt(i) = charAt(j)时，我们才需要判断[i+1,j-1]是否是一个回文串，
        因为一个回文串去掉两头的字符依旧是回文串，如果中间都不是回文串，那么两头相等也没用了
     */

    public String longestPalindrome(String s) {
        int len = s.length();
        if(len < 2) return s;   // 检查
        int begin = 0;  // 定义最长回文子串的开头
        int maxLen = 1;    // 定义最长回文子串的结尾

        // 定义状态
        boolean[][] dp = new boolean[len][len];

        char[] chars = s.toCharArray();
        for(int j = 1 ; j < len ; j++){
            for(int i = j + 1 ; i < len ; i++){
                if(chars[j] == chars[i]){
                    if(j - i < 3){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if(dp[i][j] && maxLen < j - i + 1){ // j-i+1是此时的回文串的长度
                    begin = i;
                    maxLen = j - i + 1;
                }

            }
        }
        return s.substring(begin,begin + maxLen);
    }

    public String longestPalindrome2(String s) {
        int len = s.length();
        if(len < 2) return s;   // 检查
        int begin = 0;  // 定义最长回文子串的开头
        int maxLen = 1;    // 定义最长回文子串的结尾

        // 定义状态
        boolean[] dp = new boolean[len];

        char[] chars = s.toCharArray();
        for(int j = 1 ; j < len ; j++){
            for(int i = 0 ; i < j ; i++){
                if(chars[j] == chars[i]){
                    if(j - i < 3){
                        dp[i] = true;
                    }else {
                        dp[i] = dp[i + 1];
                    }
                }
                if(dp[i] && maxLen < j - i + 1){ // j-i+1是此时的回文串的长度
                    begin = i;
                    maxLen = j - i + 1;
                }

            }
        }
        return s.substring(begin,begin + maxLen);
    }

}

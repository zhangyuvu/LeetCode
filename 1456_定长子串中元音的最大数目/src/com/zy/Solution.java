package com.zy;

import java.util.HashSet;

/**
 * @author zhangyu
 * @date 2021/9/29 16:06

    给你字符串 s 和整数 k 。

    请返回字符串 s 中长度为 k 的单个子字符串中可能包含的最大元音字母数。

    英文中的 元音字母 为（a, e, i, o, u）。

    示例 1：

    输入：s = "abciiidef", k = 3
    输出：3
    解释：子字符串 "iii" 包含 3 个元音字母。
    示例 2：

    输入：s = "aeiou", k = 2
    输出：2
    解释：任意长度为 2 的子字符串都包含 2 个元音字母。
    示例 3：

    输入：s = "leetcode", k = 3
    输出：2
    解释："lee"、"eet" 和 "ode" 都包含 2 个元音字母。
    示例 4：

    输入：s = "rhythms", k = 4
    输出：0
    解释：字符串 s 中不含任何元音字母。
    示例 5：

    输入：s = "tryhard", k = 4
    输出：1
     
    提示：

    1 <= s.length <= 10^5
    s 由小写英文字母组成
    1 <= k <= s.length
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb",33));
    }
    /*
        定长的滑动窗口 从左至右 依次滑动
     */
    public int maxVowels(String s, int k) {
        int res = 0;
        int len = s.length();
        if(len <= k){  // 当 s 的长度比 k 短的时候 跑一边就结束
            for (int i = 0; i < len ; i++){
                res += isVowel(s.charAt(i));
            }
            return res;
        }

        // 维护一个长度为 k 的滑动窗口 win win 中元音字符数量已知
        // win 一直向右滑动一格 判断 左边失去的是否是元音 和右边加入的是否是元音

        int win = 0;
        for (int i = 0; i < k; i++) {
            win += isVowel(s.charAt(i));
        }
        res = win;
        for (int i = k ; i < len ; i++){
            win += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            res = Math.max(res,win);
        }

        return res;
    }

    private int isVowel(char c){
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }

}

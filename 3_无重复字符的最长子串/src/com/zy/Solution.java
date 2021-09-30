package com.zy;

import java.util.HashSet;

/**
 * @author zhangyu
 * @date 2021/9/27 16:02

    给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。

    示例 1:

    输入: s = "abcabcbb"
    输出: 3
    解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
    示例 2:

    输入: s = "bbbbb"
    输出: 1
    解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
    示例 3:

    输入: s = "pwwkew"
    输出: 3
    解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
         请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
    示例 4:

    输入: s = ""
    输出: 0
     

    提示：

    0 <= s.length <= 5 * 104
    s 由英文字母、数字、符号和空格组成


 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("222222"));
    }

    /*
        滑动窗口  自己写的 效率低到爆炸
     */
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int len = 0;
        HashSet<Character> set = new HashSet<>();  // 用来查重的 set

        for (int i = 0; i < s.length(); i++){
            int j = i;
            for (; j < s.length(); j++){
                if(!set.add( s.charAt(j) )){  // 添加失败代表重复结束循环
                    break;
                }
            }

            len = Math.max(len, set.size());
            if( j == s.length()) break;  // j 已经跑完了整个字符串 则返回
            set.clear();
        }

        return len;
    }

}

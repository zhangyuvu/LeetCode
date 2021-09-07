package com.zy;

import java.util.Objects;

/**
 * @author zy
 *
    在一个 平衡字符串 中，'L' 和 'R' 字符的数量是相同的。
    给你一个平衡字符串 s，请你将它分割成尽可能多的平衡字符串。
    注意：分割得到的每个字符串都必须是平衡字符串。
    返回可以通过分割得到的平衡字符串的 最大数量 。

    tips：
        1 <= s.length <= 1000
        s[i] = 'L' 或 'R'
        s 是一个 平衡 字符串

 */
public class Solution {

    public static void main(String[] args) {

    }

    // 官方题解
    public int balancedStringSplit1(String s) {
        int result = 0, Count = 0;


        for (int i = 0 ; i < s.length() ; i++){
            if(s.charAt(i) == 'L'){
                Count++;
            }else {
                Count--;
            }
            if(Count == 0){
                result++;
            }
        }

        return result;

    }

    // 自己的题解
    public int balancedStringSplit(String s) {
        char[] chars = s.toCharArray();

        int i = 0;
        int lCount = 0;
        int pCount = 0;
        Character c1 = 'L';

        for (char item : chars) {
            if(c1.equals(item)){
                lCount++;
            }else {
                pCount++;
            }
            if(lCount == pCount){
                i++;
            }
        }
        
        return i;
    }

}

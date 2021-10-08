package com.zy;

import com.sun.corba.se.spi.activation.TCPPortHelper;

/**
 * @author zhangyu
 * @date 2021/10/7 10:16

    统计字符串中的单词个数，这里的单词指的是连续的不是空格的字符。

    请注意，你可以假定字符串里不包括任何不可打印的字符。

    示例:

    输入: "Hello, my name is John"
    输出: 5
    解释: 这里的单词是指连续的不是空格的字符，所以 "Hello," 算作 1 个单词。

 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().countSegmentss(",,,  aaa a a  /"));
    }


    // 标记写法
    public int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;

        int count = 0;
        boolean flag = true;
        for (int i = 0; i < s.length(); i++){

            if(flag && s.charAt(i) != ' ' ) {  // 遇见一个单词
                count++;
                flag = false;
                continue;
            }

            if( !flag && s.charAt(i) == ' '){  // 遇见空格
                flag = true;
            }
        }
        return count;
    }


    // 字符串分割写法
    public int countSegmentss(String s) {
        String[] ss = s.split(" ");
        int count = 0;
        for (String s1 : ss) {
            if(!s1.equals("")) count++;
        }

        return count;
    }
}

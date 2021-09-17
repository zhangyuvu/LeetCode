package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/17 22:53

    请实现一个函数，把字符串 s 中的每个空格替换成"%20"。

    示例 1：

    输入：s = "We are happy."
    输出："We%20are%20happy."
     
    限制：
    0 <= s 的长度 <= 10000


 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(replaceSpace("  1 2 3"));
    }

    public static String replaceSpace(String s) {
        StringBuilder builder = new StringBuilder();  // 快的一批 效率高
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' '){
                builder.append("%20");
            }else {
                builder.append(s.charAt(i));
            }
        }

        return builder.toString();

//        return s.replaceAll(" ", "%20");  // 慢的飞起
    }

}

package com.zy;

import java.util.Date;
import java.util.Timer;

/**
 * @author zhangyu
 * @date 2021/9/21 15:56
    58. 最后一个单词的长度
    给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中最后一个单词的长度。

    单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

    示例 1：

    输入：s = "Hello World"
    输出：5
    示例 2：

    输入：s = "   fly me   to   the moon  "
    输出：4
    示例 3：

    输入：s = "luffy is still joyboy"
    输出：6


    提示：

    1 <= s.length <= 104
    s 仅有英文字母和空格 ' ' 组成
    s 中至少存在一个单词

 */
public class Solution {

    public static void main(String[] args) {
        String s = "123  456       ";
        long current = System.currentTimeMillis();
        System.out.println(lengthOfLastWord(s));
        System.out.println( "耗时：" + (System.currentTimeMillis() - current));

        current = System.currentTimeMillis();
        System.out.println(lengthOfLastWord2(s));
        System.out.println( "耗时：" + (System.currentTimeMillis() - current));
    }


    public static int lengthOfLastWord(String s) {
        int res = 0;
        if(s.charAt(s.length() - 1) == ' '){  // 最后一个
            s = s.trim();
        }
        for (int i = s.length() - 1; i >= 0; i--) {
            if(s.charAt(i) != ' '){
                res++;
            }else {
                break;
            }
        }
        return res;
    }

    public static int lengthOfLastWord2(String s) {  // 这种方式内存占用更少
        int res = 0;
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if(flag){
                if(s.charAt(i) != ' '){
                    res++;
                }else {
                    break;
                }
            } else if(s.charAt(i) != ' '){
                flag = true;
                res++;
            }
        }
        return res;
    }

}

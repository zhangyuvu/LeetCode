package com.zy;

/**
 * @author zhangyu
 * @date 2021/10/2 17:13

    给定一个整数，编写一个算法将这个数转换为十六进制数。对于负整数，我们通常使用 补码运算 方法。

    注意:

    十六进制中所有字母(a-f)都必须是小写。
    十六进制字符串中不能包含多余的前导零。如果要转化的数为0，那么以单个字符'0'来表示；对于其他情况，十六进制字符串中的第一个字符将不会是0字符。 
    给定的数确保在32位有符号整数范围内。
    不能使用任何由库提供的将数字直接转换或格式化为十六进制的方法。
    示例 1：

    输入:
    26

    输出:
    "1a"
    示例 2：

    输入:
    -1

    输出:
    "ffffffff"


 */
public class Solution {

    public String toHex(int num) {
        if(num == 0)  return "0";
        StringBuilder builder = new StringBuilder();
        long n = num;

        if(n < 0){
            n = (long) (Math.pow(2,32) + n);  // 小于 0 的数加上2的32次方的得到的就是对应的补码
        }

        while (n != 0){
            long temp = n % 16;
            char c = (char)(temp + '0');
            if(temp >= 10){
                c = (char)(temp - 10 + 'a');
            }
            builder.append(c);
            n /= 16;
        }

        return builder.reverse().toString();
    }

}
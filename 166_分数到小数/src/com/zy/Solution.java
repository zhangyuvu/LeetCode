package com.zy;

import java.util.HashMap;

/**
 * @author zhangyu
 * @date 2021/10/3 22:59
    给定两个整数，分别表示分数的分子 numerator 和分母 denominator，以 字符串形式返回小数 。

    如果小数部分为循环小数，则将循环的部分括在括号内。

    如果存在多个答案，只需返回 任意一个 。

    对于所有给定的输入，保证 答案字符串的长度小于 104 。

    示例 1：

    输入：numerator = 1, denominator = 2
    输出："0.5"
    示例 2：

    输入：numerator = 2, denominator = 1
    输出："2"
    示例 3：

    输入：numerator = 2, denominator = 3
    输出："0.(6)"
    示例 4：

    输入：numerator = 4, denominator = 333
    输出："0.(012)"
    示例 5：

    输入：numerator = 1, denominator = 5
    输出："0.2"
     

    提示：

    -231 <= numerator, denominator <= 231 - 1
    denominator != 0


 */
public class Solution {

    public String fractionToDecimal(int numerator, int denominator) {
        long a = numerator, b = denominator;
        if(a % b == 0) return String.valueOf(a / b); // 能够除尽则返回

        StringBuilder sb = new StringBuilder();

        if(a * b < 0) {
            sb.append("-");  // 小于0提前加-号
            a = Math.abs(a);   // a b 取正数
            b = Math.abs(b);
        }

        sb.append(a / b + ".");  // 取整数


        a %= b;   // 取出余数
        HashMap<Long,Integer> hashMap = new HashMap<>();
        while (a != 0) {
            // 记录当前余数所在答案的位置，并继续模拟除法运算
            hashMap.put(a, sb.length());
            a *= 10;
            sb.append(a / b);
            a %= b;
            // 如果当前余数之前出现过，则将 [出现位置 到 当前位置] 的部分抠出来（循环小数部分）
            if (hashMap.containsKey(a)) {
                int u = hashMap.get(a);
                return String.format("%s(%s)", sb.substring(0, u), sb.substring(u));
            }
        }

        return sb.toString();
    }

}

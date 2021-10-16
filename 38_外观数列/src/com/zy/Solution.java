package com.zy;

/**
 * @author zhangyu
 * @date 2021/10/15 10:13

    给定一个正整数 n ，输出外观数列的第 n 项。

    「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。

    你可以将其视作是由递归公式定义的数字字符串序列：

    countAndSay(1) = "1"
    countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
    前五项如下：

    1.     1
    2.     11
    3.     21
    4.     1211
    5.     111221
    6.     312211
    第一项是数字 1
    描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
    描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
    描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
    描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
    要 描述 一个数字字符串，首先要将字符串分割为 最小 数量的组，每个组都由连续的最多 相同字符 组成。
    然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。
    要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。


 */
public class Solution {

    /*
       定义状态dp(i) 为描述第 i - 1 项的字符串
       初始值 dp(i) = 1

    */
    public String countAndSay(int n) {
        String[] dp = new String[2]; // 定义状态

        dp[1] = "1";  // 边界

        for (int i = 2 ; i <= n ; i++){ // dp[i] 描述 dp[i-1]

            dp[i & 1] = description(dp[(i - 1) & 1]);

        }

        return (n & 1) == 1 ? dp[1] : dp[0];
    }


    public String description(String temp){
        StringBuilder builder = new StringBuilder();
        int i = 0 , j = 0;       // 双指针跑字符串

        char a = temp.charAt(0);        // i 所在位置的字符
        char b = '0';                   // j 所在位置的字符

        while (j < temp.length()){      // 利用 build 对 temp 进行描述
            b = temp.charAt(j);

            if(a == b){             // j 在前面跑 遇到不相等的 追加数目和字符 将i切换到j的位置 a切换到b 代表新的一组开始了
                j++;
            }else {
                builder.append(j - i).append(a);    // 描述跑完的一组
                i = j++;
                a = b;
            }
        }
        builder.append(j - i).append(a);   // j 会越界，所以对最后一组单独处理
        return builder.toString();
    }
}

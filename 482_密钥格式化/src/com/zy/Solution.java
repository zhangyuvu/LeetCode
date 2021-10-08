package com.zy;

/**
 * @author zhangyu
 * @date 2021/10/4 20:57

有一个密钥字符串 S ，只包含字母，数字以及 '-'（破折号）。其中， N 个 '-' 将字符串分成了 N+1 组。

给你一个数字 K，请你重新格式化字符串，使每个分组恰好包含 K 个字符。
特别地，第一个分组包含的字符个数必须小于等于 K，但至少要包含 1 个字符。两个分组之间需要用 '-'（破折号）隔开，
并且将所有的小写字母转换为大写字母。

给定非空字符串 S 和数字 K，按照上面描述的规则进行格式化。

示例 1：

输入：S = "5F3Z-2e-9-w", K = 4
输出："5F3Z-2E9W"
解释：字符串 S 被分成了两个部分，每部分 4 个字符；
     注意，两个额外的破折号需要删掉。
示例 2：

输入：S = "2-5g-3-J", K = 2
输出："2-5G-3J"
解释：字符串 S 被分成了 3 个部分，按照前面的规则描述，第一部分的字符可以少于给定的数量，其余部分皆为 2 个字符。
 
提示:

    S 的长度可能很长，请按需分配大小。K 为正整数。
    S 只包含字母数字（a-z，A-Z，0-9）以及破折号'-'
    S 非空


 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(licenseKeyFormattingReverse("--a-a-a-a--",
                2));
    }

    // 倒叙
    public static String licenseKeyFormattingReverse(String s, int k){
        StringBuilder sb = new StringBuilder();

        int mark = s.length() - 1;  // 标记字符串位置 从最后一个开始

        while (mark >= 0){
            for (int i = 0 ; i < k && mark >= 0 ;mark--){
                char c = s.charAt(mark);
                if(c != '-'){
                    sb.append(Character.toUpperCase(c));
                    i++;
                }
            }
           sb.append('-');
        }

        while (sb.length() > 0 && sb.charAt(sb.length() - 1) == '-'){
            sb.deleteCharAt(sb.length() - 1);
        }

        return sb.reverse().toString();
    }

    // 正序
    public static String licenseKeyFormatting(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char c = '-';
        for (int i = 0; i < s.length(); i++){
            c = s.charAt(i);
            if(c != '-') sb.append(c);
        }
        s = sb.toString();
        int size = s.length();  // 取出非'-'的字符个数
        if(size == 0) return "";   // 内容全部是 "-"

        sb = new StringBuilder();

        int temp = size % k; // 取出余数 放在第一部分
        int mark = 0;  // 标记字符串位置

        // 处理第一部分
        for(; mark < temp; mark++){
            c = s.charAt(mark);
            sb.append(Character.toUpperCase(c));
        }

        temp = size / k; // 取出除开余数部分总共有几部分

        while (temp-- > 0){
            sb.append('-');
            // 每部分放k个字符
            for(int i = 0; i < k; i++){
                c = s.charAt(mark);

//                // 速度更快的写法
//                if(c > 96) c = (char)(c - 32); // 小写转大写
//                sb.append(c);

                // 内存占用更少的写法
                sb.append(Character.toUpperCase(c));
                mark++;
            }
        }

        if(size % k == 0)  sb.deleteCharAt(0); // 不存在余数则除去最头上的 '-'

        return sb.toString();
    }

}

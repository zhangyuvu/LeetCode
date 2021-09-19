package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/19 20:21

    写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：

    F(0) = 0,   F(1) = 1
    F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
    斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。

    答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。

    示例 1：

        输入：n = 2
        输出：1

    示例 2：

        输入：n = 5
        输出：5

    提示：

    0 <= n <= 100


 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(fib2(30));
        System.out.println(fib(30));
    }


    public static int fib(int n) {
        if(n < 2){ // 前两个值的话由于确定 可以直接返回
            return n == 0 ? 0 : 1;
        }
        // first 是前一个值，sec 是当前值，temp 用来进行值替换时的过渡
        int first = 0, sec = 1,temp = 0;

        while (n > 1){ // 由于前两个值确定，所以 n 从 2 开始计算

            temp = sec;
            sec = (first + sec) % 1000000007;
            first = temp;

            --n;
        }

        return sec;
    }

    public static int fib2(int n) {
        if(n == 0){
            return 0;
        }else if(n == 1){
            return 1;
        }
        return fib2(n-1) + fib2(n-2);
    }


}

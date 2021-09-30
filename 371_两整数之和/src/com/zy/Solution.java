package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/26 12:10

    给你两个整数 a 和 b ，不使用 运算符 + 和 - ，计算并返回两整数之和。 

    示例 1：

    输入：a = 1, b = 2
    输出：3
    示例 2：

    输入：a = 2, b = 3
    输出：5
 

    提示：

    -1000 <= a, b <= 1000


 */
public class Solution {

    public int getSum(int a, int b) {
        if(a == 0 ) return b;
        if(b == 0 ) return a;
        int res = 0;

        if(a < 0 && b < 0){ // a b 都小于0
            for(int i =0; i>a;i--){
                res--;
            }
            for(int i =0; i>b;i--){
                res--;
            }
        }else if(b < 0){  // 只有 b 小于 0
            for(int i =0; i<a;i++){
                res++;
            }
            for(int i =0; i>b;i--){
                res--;
            }
        }else if(a < 0){  // 只有 a 小于 0
            for(int i =0; i>a;i--){
                res--;
            }
            for(int i =0; i<b;i++){
                res++;
            }
        }else {   // a b全部大于 0
            for(int i =0; i<a;i++){
                res++;
            }
            for(int i =0; i<b;i++){
                res++;
            }
        }

        return res;
    }

}

package com.zy;

/**
 * @author zy
 * 一个班级里有 n 个学生，编号为 0 到 n - 1 。
    每个学生会依次回答问题，编号为 0 的学生先回答，然后是编号为 1 的学生，以此类推，直到编号为 n - 1 的学生，
    然后老师会重复这个过程，重新从编号为 0 的学生开始回答问题。

    给你一个长度为 n 且下标从 0 开始的整数数组 chalk 和一个整数 k 。
    一开始粉笔盒里总共有 k 支粉笔。当编号为 i 的学生回答问题时，他会消耗 chalk[i] 支粉笔。如果剩余粉笔数量 严格小于 chalk[i] ，
    那么学生 i 需要 补充 粉笔。

    请你返回需要 补充 粉笔的学生 编号 。

    tips:
        chalk.length == n
        1 <= n <= 105
        1 <= chalk[i] <= 105
        1 <= k <= 109

 */
public class Solution {

    public static void main(String[] args) {

        System.out.println(ss());

    }

    public static int ss(){
        int i = 0;
        return i++;
    }

    // k个粉笔
    public int chalkReplacer(int[] chalk, int k) {
        long total = 0L;  // 用int会导致值溢出，坑

        for (int i : chalk) {
            total += i;  // 拿到每一次循环所耗费的粉笔总数
        }

        // 求模 判断k是否刚好用完
        if((k %= total) == 0){
            return 0;
        }else{
            for (int i = 0; i < chalk.length ; i++ ){
                k -= chalk[i];
                if(k == 0){  // k在那一组被用完
                    return  i == chalk.length - 1 ? 0 : ++i ;  // 又吃一坑， 返回i++ 等于 返回 i
                }else if(k < 0){
                    return i;
                }
            }
        }

        return 0;
    }
}

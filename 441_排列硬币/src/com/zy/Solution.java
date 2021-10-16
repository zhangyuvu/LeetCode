package com.zy;

/**
 * @author zhangyu
 * @date 2021/10/10 10:57
    你总共有 n 枚硬币，并计划将它们按阶梯状排列。对于一个由 k 行组成的阶梯，
其第 i 行必须正好有 i 枚硬币。阶梯的最后一行 可能 是不完整的。

    给你一个数字 n ，计算并返回可形成 完整阶梯行 的总行数。


    输入：n = 5
    输出：2
    解释：因为第三行不完整，所以返回 2 。


 */
public class Solution {

    /*
        按照 n 每一层会用掉该层号个硬币 当 n 不大于该层号硬币时 存在两种情况
        第一种 该层号硬币多余 n 则 返回上一层层号
        第二种 该层号硬币等于 n 则 返回当前层号
        效率低下
     */

    public int arrangeCoins(int n) {
        int res = 1;
        while(n > res){
            n -= res++;
        }
        return res == n ? res : res - 1;
    }

}

package com.zy;

import java.util.*;

/**
 * @author zhangyu
 * @date 2021/10/6 8:08

    给你一个非空数组，返回此数组中 第三大的数 。如果不存在，则返回数组中最大的数。 

    示例 1：

    输入：[3, 2, 1]
    输出：1
    解释：第三大的数是 1 。
    示例 2：

    输入：[1, 2]
    输出：2
    解释：第三大的数不存在, 所以返回最大的数 2 。
    示例 3：

    输入：[2, 2, 3, 1]
    输出：1
    解释：注意，要求返回第三大的数，是指在所有不同数字中排第三大的数。
    此例中存在两个值为 2 的数，它们都排第二。在所有不同数字中排第三大的数为 1 。
     

    提示：

    1 <= nums.length <= 104
    -231 <= nums[i] <= 231 - 1


 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.thirdMax(new int[]{1,1,2,-2147483648}));

        TreeSet<Integer> values = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 > o2 ? -1 : (o1 == o2 ? 0 : 1);
            }
        });

        values.add(1);
        values.add(2);
        values.add(3);

        System.out.println(values);
    }

    public int thirdMax(int[] nums) {
        TreeSet<Integer> values = new TreeSet<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);    // 从大到小排序
            }
        });

        for (int num : nums) {  // 存放所有的值
            values.add(num);
        }
        // 第三大的数不存在,返回最大值
        if(values.size() < 3) return values.first();

        values.pollFirst();
        values.pollFirst();

        return values.first();
    }

}

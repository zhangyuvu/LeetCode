package com.zy;

import java.util.Arrays;

/**
 * @author zy
    学校打算为全体学生拍一张年度纪念照。根据要求，学生需要按照 非递减 的高度顺序排成一行。
    排序后的高度情况用整数数组 expected 表示，其中 expected[i] 是预计排在这一行中第 i 位的学生的高度（下标从 0 开始）.
    给你一个整数数组 heights ，表示 当前学生站位 的高度情况。heights[i] 是这一行中第 i 位学生的高度（下标从 0 开始）。
    返回满足 heights[i] != expected[i] 的 下标数量 。

    提示：

    1 <= heights.length <= 100
    1 <= heights[i] <= 100
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(heightChecker(new int[]{1, 1, 4, 2, 1, 3}));
    }

    public static int heightChecker(int[] heights) {

        int[] ints = heights.clone();
        Arrays.sort(heights);
        int result = 0;
        for (int i = 0; i < heights.length; i++) {
            if(ints[i] != heights[i]){
                ++result;
            }
        }

        return result;
    }

    public int heightChecker2(int[] heights) {
        int result = 0;
        int[] b = new int[101];
        for (int height : heights) {
            b[height]++;  // 索引heigth位置的元素加一
        }

        for(int i = 1, j = 0; i < b.length ; i++){
            while (b[i]-- > 0){
                if(heights[j++] != i) result++;
            }
        }

        return result;
    }
}

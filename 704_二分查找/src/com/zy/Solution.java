package com.zy;

/**
 * @author zy
给定一个 n 个元素 有序的（升序）整型数组 nums 和一个目标值 target，
写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。

1.可以假设 nums 中的所有元素是不重复的。
2.n 将在 [1, 10000]之间。
3.nums 的每个元素都将在 [-9999, 9999]之间。
 */
public class Solution {

    public static void main(String[] args) {

        Solution solution = new Solution();
//        int i = solution.search(new int[]{-5,-1,0,1,2,5,6}, -1);
        int i = solution.search(new int[]{-5,-3,-2,-1,1,2,3,4,5,6,7,8,9,10,11}, 12);
        System.out.println(i);
//        System.out.println(Math.ceil(0 / 2d));
    }


    public int search(int[] nums, int target) {

        int size =  nums.length; // 获取数组大小

        int left = 0;
        int right = size - 1;

        // 重合的时候还未找到结束循环返回 -1
        while (left <= right){
            int index = left + ((right - left) / 2);  // 获取 [left , right]  的中间索引
            if(target > nums[index]){
                left = index + 1;
            }else if(target < nums[index]){
                right = index - 1;
            }else {
                return index;
            }
        }

        return -1;
    }

}

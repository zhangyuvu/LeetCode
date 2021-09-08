package com.zy;

import java.util.HashMap;

/**
 * @author zy
 */
public class Solution {

    public static void main(String[] args) {

        int[] i = {0,1};
        for (int i1 : twoSum(i, 4)) {
            System.out.println(i1);
        }

    }

    // 自己想到的方法是暴力递归，想着应该还有更加优秀的解法 直接看到官方解法 使用hashMap的高效查询来完成

    public static int[] twoSum(int[] nums, int target) {
        if (nums.length == 2) return new int[]{0,1};

        HashMap<Integer,Integer> hashMap = new HashMap<>();
        hashMap.put(nums[0], 0);

        for(int i = 1; i < nums.length ; i++){
            if(!hashMap.containsKey(target - nums[i])){
                hashMap.put(nums[i],i);
            }else {
                return new int[]{hashMap.get(target - nums[i]), i};
            }
        }
        return new int[0];
    }



}

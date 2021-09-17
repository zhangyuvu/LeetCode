package com.zy;

/**
 * @author zhangyu
 * @date 2021/9/16 22:44

    以最左下角的元素为根节点 大于它的一定在它所属列的右边 小于它的 一定在它所在行的上面 让根节点不停切换 就可以找到 target

 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findNumberIn2DArray(new int[][]{{1, 2, 3}, {4, 5, 6}}, 3));
    }


    public boolean findNumberIn2DArray(int[][] matrix, int target){

        int row = matrix.length - 1;
        int column = 0;

        while ( row >= 0 && column < matrix[row].length ){
            if(matrix[row][column] > target){
                --row;
            }else if(matrix[row][column] < target){
                ++column;
            }else {
                return true;
            }
        }
        return false;
    }

}

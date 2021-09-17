package com.zy;

import java.util.HashSet;

/**
 * @author zhangyu
 * @date 2021/9/17 20:50

    请你判断一个 9x9 的数独是否有效。只需要 根据以下规则 ，验证已经填入的数字是否有效即可。

    数字 1-9 在每一行只能出现一次。
    数字 1-9 在每一列只能出现一次。
    数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
    数独部分空格内已填入了数字，空白格用 '.' 表示。

    注意：

    一个有效的数独（部分已被填充）不一定是可解的。
    只需要根据以上规则，验证已经填入的数字是否有效即可。

    提示：

    board.length == 9
    board[i].length == 9
    board[i][j] 是一位数字或者 '.'

 */
public class Solution {

    // 官方题解
    public boolean isValidSudoku(char[][] board) {
        int[][] rows = new int[9][9];      // 9行 记录每一行中每个元素的出现个数
        int[][] columns = new int[9][9];   // 9列 记录每一列中每一个元素出现个数
        int[][][] boxes = new int[3][3][9];  // 将整个方块 分为九个小方块 每个小方块内九个元素 [0][0] 为第一个方块 [0][1] 为第二个方块 依次类推

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++){
                char c = board[i][j];
                if(c != '.'){
                    int index = c - '0' - 1;  // 算出该元素对应的索引
                    rows[i][index]++;        // 第 i 行的 index 号元素出现了一次
                    columns[j][index]++;     // 第 j 列的 index 号元素出现了一次
                    boxes[i / 3][j / 3][index]++; // 对应方块的 index 号元素出现了一次
                    if(rows[i][index] > 1 || columns[j][index] >1 || boxes[i / 3][j / 3][index] > 1){  // 有元素出现了两次及以上
                        return false;
                    }
                }

            }
        }
        return true;
    }


    // 自己的超强暴力题解
    public boolean isValidSudoku1(char[][] board) {
        HashSet<Character> hashSet = new HashSet<>();

        // 判断每行重复元素
        for (int i = 0; i < 9; i++) {
            for (char c : board[i]) {
                if( c != '.' && !hashSet.add(c)) return false; // 如果有一个元素添加失败
            }
            hashSet.clear();
        }


        // 判断每列重复元素
        for(int i = 0; i < 9 ; i++){
            for (int j = 0; j < 9 ; j++){
                if(board[j][i] != '.' && !hashSet.add(board[j][i])) return false;
            }
            hashSet.clear();
        }
        int temp = 0;
        // 判断3x3宫格
        for(int i = 0; i < 9 ; i++){
            if(i < 3){
                for(int j = 0; j < 3; j++){
                    for (int k = 0; k < 3; k++) {
                        temp = k + i*3;
                        if(board[j][temp] != '.' && !hashSet.add(board[j][temp])) return false;
                    }
                }
                hashSet.clear();
            } else if(i < 6){
                for(int j = 3; j < 6; j++){
                    for (int k = 0; k < 3; k++) {
                        temp = k + (i - 3)*3;
                        if(board[j][temp] != '.' && !hashSet.add(board[j][temp])) return false;
                    }
                }
                hashSet.clear();
            } else {
                for(int j = 6; j < 9; j++){
                    for (int k = 0; k < 3; k++) {
                        temp = k + (i - 6)*3;
                        if(board[j][temp] != '.' && !hashSet.add(board[j][temp])) return false;
                    }
                }
                hashSet.clear();
            }
        }
        return true;
    }


}

package com.zy;

import java.util.Stack;

/**
 * @author zy
    给定一个只包含三种字符的字符串：（ ，） 和 *，写一个函数来检验这个字符串是否为有效字符串。有效字符串具有如下规则：

    任何左括号 ( 必须有相应的右括号 )。
    任何右括号 ) 必须有相应的左括号 ( 。
    左括号 ( 必须在对应的右括号之前 )。
     * 可以被视为单个右括号 ) ，或单个左括号 ( ，或一个空字符串。
    一个空字符串也被视为有效字符串。

 tip:
    字符串大小将在 [1，100] 范围内。

 */
public class Solution {

    public static void main(String[] args) {
        Stack<Integer> leftStack = new Stack<>();  // 左括号栈
        leftStack.push(1);
        leftStack.push(2);
        System.out.println(leftStack.pop());
        System.out.println(leftStack.pop());
    }

    public boolean checkValidString(String s) {

        Stack<Integer> leftStack = new Stack<>();  // 左括号栈
        Stack<Integer> starStack = new Stack<>();  // 星号栈

        // 从头遍历字符串 遇到左括号入栈 遇到星号入栈 遇到右括号优先左括号元素出栈 其次星号出栈
        for (int i = 0; i < s.length(); i++) {
            char item = s.charAt(i);
            if(item == '('){
                leftStack.push(i);
            }else if(item == '*'){
                starStack.push(i);
            }else {
                if(!leftStack.empty()){
                    leftStack.pop();
                }else if(!starStack.empty()){
                    starStack.pop();
                }else {
                    return false;
                }
            }
        }

        // 字符串遍历完之后
        while (!leftStack.empty() && !starStack.empty()){
            if(leftStack.pop() > starStack.pop()) {  // 最右边的左括号的下标大于最右边的星号下标 代表有一个左括号没有匹配 返回false
                return false;
            }
        }

        return leftStack.empty();
    }
}

package com.zy;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author zhangyu
 * @date 2021/9/18 22:46

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

    1 <= values <= 10000
    最多会对 appendTail、deleteHead 进行 10000 次调用

 */
public class CQueue {

    Stack<Integer> appendStack;
    Stack<Integer> deleteStack;

    public CQueue() {
        appendStack = new Stack<>();
        deleteStack = new Stack<>();
    }

    public void appendTail(int value) {
        appendStack.push(value);
    }

    public int deleteHead() {
        if(deleteStack.isEmpty()){
            if(appendStack.isEmpty()){
                return -1;
            }else {
                while (!appendStack.isEmpty()){
                    deleteStack.push(appendStack.pop());
                }
            }
        }

        return deleteStack.pop();
    }
}

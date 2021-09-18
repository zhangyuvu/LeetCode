package com.zy;

import java.util.*;

/**
 * @author zhangyu
 * @date 2021/9/18 21:29

    输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。

    示例 1：
        输入：head = [1,3,2]
        输出：[2,3,1]
     
    限制：
    0 <= 链表长度 <= 10000
 */
public class Solution {

    // 队列解法 利用栈先进后出的思维
    public int[] reversePrint1(ListNode head) {
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        while (head != null){
            arrayDeque.addFirst(head.val);
            head = head.next;
        }
        int[] ints = new int[arrayDeque.size()];

        int i = 0;

        while (!arrayDeque.isEmpty()){
            ints[i++] = arrayDeque.pollFirst();
        }

        return ints;
    }

    // 遍历两次数组解法
    public int[] reversePrint(ListNode head){
        int len = getLength(head);

        int[] ints = new int[len];

        while (head != null){
            ints[--len] = head.val;
            head = head.next;
        }

        return ints;
    }

    private int getLength(ListNode head){
        int len = 0;
        while (head != null){
            len++;
            head = head.next;
        }
        return len;
    }

}

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}

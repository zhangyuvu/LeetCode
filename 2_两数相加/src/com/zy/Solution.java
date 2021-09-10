package com.zy;

import java.util.List;

/**
 * @author zy

    给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
    请你将两个数相加，并以相同形式返回一个表示和的链表。
    你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

    tips:
        每个链表中的节点数在范围 [1, 100] 内
        0 <= Node.val <= 9
        题目数据保证列表表示的数字不含前导零

 */
public class Solution {

    public static void main(String[] args) {

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int temp = 0;  // 记录进位数值
        int l1Size = 1;	// 链表l1的长度
        int l2Size = 1; // 链表l2的长度
        ListNode tempNode = l1;
        ListNode shortNode = null;
        int size = 0;  // 最终节点相加的次数（循环的次数）

        // 获取两个链表的长度
        while (tempNode.next != null){
            tempNode = tempNode.next;
            l1Size++;
        }
        tempNode = l2;
        while (tempNode.next != null){
            tempNode = tempNode.next;
            l2Size++;
        }

        // 获取短的链表的长度为循环次数，并且操作长的链表
        if(l1Size > l2Size){
            tempNode = l1;
            shortNode = l2;
            size = l2Size;
        }else {
            tempNode = l2;
            shortNode = l1;
            size = l1Size;
        }



        for (int i = 0; i < size; i++){
            // 开始之前就将temp值加上去
            shortNode.val += temp;

            if((tempNode.val += shortNode.val) >=10 ){
                temp = 1; // 赋值的同时修改temp的值
                tempNode.val -= 10;
            }else {
                temp = 0;  // 为满足进位条件修改temp的值
            }

            // 遍历到最后一次准备出循环的时候 让shortNode 拿到tempNode的当前值 为后续判断做准备
            shortNode = i == size - 1 ? tempNode : shortNode.next;
            tempNode = tempNode.next;

        }

        // 遍历长链表剩下的部分 如果temp还是1 则往后面节点加一
        while ( temp == 1 ){
            if(tempNode == null){ // 最后一个节点是Null 并且temp等于1 的时候新建节点

                shortNode.next = new ListNode(1);
                break;

            } else if( (tempNode.val += 1) >= 10){

                tempNode.val -= 10;
                shortNode = tempNode; // 始终记录下tempNode的当前节点 以免tempNode.next为null
                tempNode = tempNode.next;

            }else {
                break;
            }
        }
        // 返回长链表的头部节点
        return size == l1Size ? l2 : l1;
    }

}

class ListNode {
    int val; // 值
    ListNode next;  // 下一个节点
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

package com.zy;

import java.util.ArrayDeque;

/**
 * @author zhangyu
 * @date 2021/9/24 15:33

    多级双向链表中，除了指向下一个节点和前一个节点指针之外，它还有一个子链表指针，可能指向单独的双向链表。

    这些子列表也可能会有一个或多个自己的子项，依此类推，生成多级数据结构，如下面的示例所示。

    给你位于列表第一级的头节点，请你扁平化列表，使所有结点出现在单级双链表中。


 */
public class Solution {

    public static void main(String[] args) {
        ArrayDeque<Integer> nodeDeque = new ArrayDeque<>();  // 存放节点的队列 用来充当栈

        nodeDeque.addFirst(1);
        nodeDeque.addFirst(2);
        System.out.println(nodeDeque.pollFirst());
        System.out.println(nodeDeque.size());
    }

    public Node flatten(Node head) {
        if(head == null){
            return head;
        }

        ArrayDeque<Node> nodeDeque = new ArrayDeque<>();  // 存放节点的队列 用来充当栈

        Node tempNode = head;

        while (tempNode != null){

            if(tempNode.child != null){  // 节点有子节点

                if(tempNode.next != null){  // 有子节点且有next
                    nodeDeque.addFirst(tempNode.next);   // next节点入栈
                }

                tempNode.next = tempNode.child;  // 更换子节点和下一个节点的位置
                tempNode.next.prev = tempNode;
                tempNode.child = null;          // child 设置为null 因为 child 移动到next 了
            }

            if(tempNode.next != null){
                tempNode = tempNode.next;
                continue;
            }

            if(!nodeDeque.isEmpty()){
                tempNode.next = nodeDeque.pollFirst();
                tempNode.next.prev = tempNode;
                tempNode = tempNode.next;
            }else {
                break;
            }
        }

        return head;
    }
}

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
}
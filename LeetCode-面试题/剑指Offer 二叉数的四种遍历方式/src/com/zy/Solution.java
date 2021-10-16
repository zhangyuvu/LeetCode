package com.zy;

import javax.xml.soap.Node;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zhangyu
 * @date 2021/10/12 14:22
 */
public class Solution {

    // 递归前序遍历  遍历顺序 中 左 右
    public void preOrderTraversal(TreeNode root){
        if(root == null) return;

        // 先访问自己 再访问左子树 再是右子树
        System.out.println(root.val);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);

    }

    // 非递归实现前序遍历  利用栈来保存右子树的值
    public void preOrder(TreeNode root){
        if(root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();     // 队列模拟栈
        TreeNode node = root;
        // 中 左 右 一路往左走 遇到一个左就访问一次 直到走到尽头 在访问栈中弹出来的右子节点
        while(true){
            if (node != null) {
                System.out.println(node.val);   // 先访问自己 也就是中 再往左走 右子节点入栈

                if(node.right != null){
                    stack.offerFirst(node.right);
                }

                node = node.left;
            } else if(stack.isEmpty()) {
                return;
            }else {                         // 直到没有左子节点了 中也访问了 再到 右 从栈中弹出右子节点 当成一个全新的树
                node =stack.pollFirst();       // 符合 中 左 右 的逻辑
            }
        }
    }


    // 前序遍历的另一种实现   根节点入栈之后 弹出一个节点就访问 然后将右节点入栈 左节点入栈 依据循环发现逻辑符合前序遍历
    public void preOrder2( TreeNode root ){
        if (root == null) return;
        Deque<TreeNode> stack = new LinkedList<>();
        stack.offerFirst(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pollFirst();
            System.out.println(node.val);
            if(node.right != null) stack.offerFirst(node.right);
            if(node.left != null) stack.offerFirst(node.left);
        }

    }

    // 递归中序遍历  遍历顺序 中 左 右
    public void inOrderTraversal(TreeNode root){
        if(root == null) return;
        // 先访问左子树  再是自己 再是右子树
        preOrderTraversal(root.left);
        System.out.println(root.val);
        preOrderTraversal(root.right);
    }

    // 非递归中序遍历  遍历顺序 中 左 右
    public void inOrder(TreeNode root){
        if(root == null) return;

        Deque<TreeNode> stack = new LinkedList<>();     // 队列模拟栈
        TreeNode node = root;

        while (true){
            if(node != null){
                stack.offerFirst(node);         // 一路左走 把遇到的所有节点都放入栈
                node = node.left;
            } else if(stack.isEmpty()){
                return;
            }else {  // 左边走到底部了
                node = stack.pollFirst();      // 弹出栈顶访问
                System.out.println(node.val);

                node = node.right;    // 把右子树当成一个全新的子树，使用这个逻辑再次遍历 符合 左 中 右
            }
        }
    }



    // 递归后序遍历  遍历顺序 左 右 中
    public void postOrderTraversal(TreeNode root){
        if(root == null) return;

        // 先访问左子树 再是右字数 最后是自己
        preOrderTraversal(root.right);
        preOrderTraversal(root.left);
        System.out.println(root.val);
    }


    // 非递归后序遍历   根节点先入栈 然后右子节点入栈 然后左子节点入栈 随后再看一眼栈顶 又是右子节点入栈 左子节点入栈
    //                到时候弹栈的时候就符合 左 右 中 这样的后序逻辑
    public void postOrder(TreeNode root){
        if(root == null) return;
        TreeNode prev = root;
        Deque<TreeNode> stack = new LinkedList<>();     // 队列模拟栈
        stack.offerFirst(root);

        while (!stack.isEmpty()){
            TreeNode top = stack.peek(); // 看一眼栈顶元素
            if(isLeaf(top) || (top.left == prev || top.right == prev) ){      // 是叶子节点 或者父节点 才能被访问
                prev = stack.pollFirst();
                System.out.println(prev.val);
            }else {
                if(top.right != null) stack.offerFirst(top.right);
                if(top.left != null) stack.offerFirst(top.left);
            }
        }
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode();
        root.val =  1;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);


        Solution solution = new Solution();
        solution.postOrder(root);

    }

    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }


    // 层序遍历  一层一层的遍历
    public void levelOrderTraversal(TreeNode root){
        if(root == null) return;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.offer(root);
        TreeNode node = null;

        while (!nodes.isEmpty()){
            node = nodes.poll();
            System.out.println(node.val);
            if(node.left != null){
                nodes.offer(node.left);
            }
            if(node.right != null){
                nodes.offer(node.right);
            }
        }
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
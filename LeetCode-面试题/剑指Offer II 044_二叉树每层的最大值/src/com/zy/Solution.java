package com.zy;

import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangyu
 * @date 2021/10/12 10:55

    给定一棵二叉树的根节点 root ，请找出该二叉树中每一层的最大值。

    示例1：

    输入: root = [1,3,2,5,3,null,9]
    输出: [1,3,9]
    解释:
    1
    / \
    3   2
    / \   \
    5   3   9
    示例2：

    输入: root = [1,2,3]
    输出: [1,3]
    解释:
    1
    / \
    2   3
    示例3：

    输入: root = [1]
    输出: [1]
    示例4：

    输入: root = [1,null,2]
    输出: [1,2]
    解释:
               1
                \
                 2
    示例5：

    输入: root = []
    输出: []
     

    提示：

    二叉树的节点个数的范围是 [0,104]
    -231 <= Node.val <= 231 - 1


 */
public class Solution {

    // 层序遍历
    public List<Integer> largestValues(TreeNode root) {
        ArrayList<Integer> values = new ArrayList<>();
        if(root == null) return values;
        ArrayDeque<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root); // 放入第一层

        TreeNode node = null;
        int max = root.val; // 保存每一层的最大值
        int size = 1;   // 记录每层的元素

        while (!nodes.isEmpty()){
            node = nodes.poll();
            max = Math.max(max, node.val);
            size--;
            if(node.left != null){
                nodes.add(node.left);
            }
            if(node.right != null){
                nodes.add(node.right);
            }
            if(size == 0) {  // 一层已经访问完了
                values.add(max);
                max = Integer.MIN_VALUE;
                size = nodes.size();
            }
        }
        return values;
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
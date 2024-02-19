package com.zhw.leetcode.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @Date: 2024-02-18 22:55
 * @Description: 二叉树非递归的前序遍历（中左右）
 **/
public class BinaryTreeTest1 {
    public static void main(String[] args) {
        /**
         *        1
         *      /  \
         *     3    2
         *   /  \
         *  5    4
         */

        TreeNode root = new TreeNode(1);
        TreeNode leftNode = new TreeNode(3);

        leftNode.setRightNode(new TreeNode(4));
        leftNode.setLeftNode(new TreeNode(5));
        root.setLeftNode(leftNode);
        TreeNode rightNode = new TreeNode(2);
        root.setRightNode(rightNode);
        List<Integer> integers = test1(root);
        System.out.println(integers.toString());
    }


    /**
     * 非递归使用栈模拟过程，前序遍历
     * @param root
     * @return
     */
    private static List<Integer> test1(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>(0);
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop(); // 出栈
            System.out.println(node.val);
            list.add(node.val);
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return list;
    }

    public static class TreeNode {
        private int val;
        private TreeNode leftNode;
        private TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
        }

        public void setLeftNode(TreeNode leftNode) {
            this.leftNode = leftNode;
        }

        public void setRightNode(TreeNode rightNode) {
            this.rightNode = rightNode;
        }

    }
}

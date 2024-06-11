package com.zhw.leetcode.tree;


import java.util.ArrayList;
import java.util.Collections;
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

        List<Integer> integers1 = test1(root);
        System.out.println(integers1);

    }


    /**
     * 非递归使用栈模拟过程
     * 前序遍历 中左右
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
            // 先将右节点入栈
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
            // 再将左节点入栈
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
        }
        return list;
    }

    /**
     * 中序遍历，使用一个指针跌点节点，一路向左入栈，最后左节点为空时，开始出栈，那么
     * @return
     */
    public static List<Integer> test3(TreeNode root) {
        List<Integer> result = new ArrayList<>(0);
        if (root == null) {
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root; // 指针进行迭代
        while (curr != null || !stack.isEmpty()) {
            if (curr != null) {
                stack.push(curr);
                curr = curr.leftNode;
            } else {
                curr = stack.pop(); // 出栈
                result.add(curr.val);
                curr = curr.rightNode;
            }
        }
        return result;

    }

    /**
     * 后序遍历：左右中
     * 先序遍历是中左右，对于后续遍历只需要将左右两个节点入栈调转，最后再加数组反转，就得到了后续遍历的结果
     * @param root
     * @return
     */
    private static List<Integer> test2(TreeNode root) {
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
            // 先将左节点入栈
            if (node.leftNode != null) {
                stack.push(node.leftNode);
            }
            // 再将右节点入栈
            if (node.rightNode != null) {
                stack.push(node.rightNode);
            }
        }
        // 反转数组
        Collections.reverse(list);
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

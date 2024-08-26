package com.zhw.leetcode.tree;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层序遍历-广度优先搜索
 * 知识点：二叉树，队列
 */
public class BinaryTreeTest2 {
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
        // List<List<Integer>> lists = levelOrder(root);
        List<List<Integer>> lists = levelOrderRecursion(root);
        System.out.println(lists);


    }

    /**
     * 递归解法
     * @return
     */
    public static List<List<Integer>> levelOrderRecursion(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        addNode(root, 0, result);
        return result;

    }

    private static void addNode(TreeNode node, int level, List<List<Integer>> levels) {
        if (levels.size() == level) {
            levels.add(new ArrayList<>());
        }
        levels.get(level).add(node.val);
        if (node.leftNode != null) {
            addNode(node.leftNode, level + 1, levels);
        }
        if (node.rightNode != null) {
            addNode(node.rightNode, level + 1, levels);
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList();
        queue.add(root);
        int cc = 0;
        while (queue.size() != 0) {
            cc = queue.size();
            List<Integer> res = new ArrayList<>();
            while (cc > 0) {
                TreeNode node = queue.poll();
                res.add(node.val);
                if (node.leftNode != null) {
                    queue.offer(node.leftNode);
                }
                if (node.rightNode != null) {
                    queue.offer(node.rightNode);
                }
                cc--;
            }
            result.add(res);

        }
        return result;

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

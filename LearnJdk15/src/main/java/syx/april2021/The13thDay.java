package syx.april2021;


import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * * syx.april2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/4/13 下午 1:58
 */
public class The13thDay {

    /**
     * 题目：783. 二叉搜索树节点最小距离
     * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
     * 相关标签：树、深度优先搜索、递归
     * https://leetcode-cn.com/problems/minimum-distance-between-bst-nodes/
     */

    private static List<Integer> list;

    public int minDiffInBST(TreeNode root) {
        list = new ArrayList<>();
        // 获取树中所有节点
        getTreeNode(root);
        int min = Integer.MAX_VALUE;
        int temp;
        for (int i = 1; i < list.size(); i++) {
            temp = Math.abs(list.get(i) - list.get(i - 1));
            min = Math.min(min, temp);
        }
        return min;
    }

    private void getTreeNode(TreeNode root) {
        if (root == null) {
            return;
        }
        // 对树进行遍历
        getTreeNode(root.left);
        list.add(root.val);
        getTreeNode(root.right);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    @Test
    public void test() {
        TreeNode treeNode = new TreeNode(27, null, new TreeNode(34, null, new TreeNode(58, new TreeNode(50, new TreeNode(44, null, null), null), null)));
        int min = minDiffInBST(treeNode);
        System.out.println(min);

    }

}

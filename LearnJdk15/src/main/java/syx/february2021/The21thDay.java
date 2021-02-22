package syx.february2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/20 18:15
 */
public class The21thDay {

    /**
     * 题目：二叉树的最大深度 给定一个二叉树，找出其最大深度 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数
     * 叶子节点是指没有子节点的节点
     * 相关标签：树、深度优先搜索、递归
     * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/
     */
    class A {

        public int maxDepth(TreeNode root) {
            if (root == null) {
                return 0;
            }
            // 循环左节点和循环右节点，获取对应值进行比较，+1代表增加根节点数据
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }

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

    public static int count = 0;

    class B {
        /**
         * 题目：多数元素 给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素
         * 相关标签：位运算、数组、分治算法
         * https://leetcode-cn.com/problems/majority-element/
         */
        public int majorityElement(int[] nums) {
            Map<Integer, Integer> map = new HashMap<>();
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int sumCount = nums.length / 2;
            for (int i = 0; i < nums.length; i++) {
                if (map.containsKey(nums[i])) {
                    map.replace(nums[i], map.get(nums[i]) + 1);
                    if (map.get(nums[i]) > sumCount) {
                        return nums[i];
                    }
                } else {
                    map.put(nums[i], 1);
                }
            }
            return 0;
        }
    }

    @Test
    public void test2() {
        System.out.println(new B().majorityElement(new int[]{1}));
    }


    class C {
        /**
         * 题目：对称二叉树 给定一个二叉树，检查它是否是镜像对称的
         * 相关标签：树、深度优先搜索、广度优先搜索
         * https://leetcode-cn.com/problems/symmetric-tree/
         */
        public boolean isSymmetric(TreeNode root) {
            if (root == null || (root.left == null && root.right == null)) {
                return true;
            }
            return validLeftRight(root.left, root.right);
        }

        public boolean validLeftRight(TreeNode left, TreeNode right) {
            if (left == null && right == null) {
                return true;
            }
            if (left == null || right == null) {
                return false;
            }
            return left.val == right.val && validLeftRight(left.right, right.left) && validLeftRight(left.left, right.right);
        }
    }

    class D {
        /**
         * 题目：只出现一次的数字
         * 给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素
         * https://leetcode-cn.com/problems/single-number/
         */
//        public int singleNumber(int[] nums) {
//            Map<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
//            }
//            AtomicInteger result = new AtomicInteger();
//            map.forEach((num, count) -> {
//                if (count == 1) {
//                    result.set(num);
//                }
//            });
//            return result.get();
//        }
        public int singleNumber(int[] nums) {

            int result = 0;
            for (int num : nums) {
                // 异或
                result ^= num;
            }
            return result;
        }
    }

}

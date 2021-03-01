package syx.march2021;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/1 10:27
 */
public class The1thDay {

    /**
     * 题目：区域和检索-数组不可变
     * 给定一个整数数组  nums，求出数组从索引 i 到 j（i ≤ j）范围内元素的总和，包含 i、j 两点。\
     * 实现 NumArray 类：
     * NumArray(int[] nums) 使用数组 nums 初始化对象
     * int sumRange(int i, int j) 返回数组 nums 从索引i到j（i≤j）范围内元素的总和，包含i、j两点（也就是 sum(nums[i], nums[i + 1], ... , nums[j])）
     * 相关标签：动态规划
     * https://leetcode-cn.com/problems/range-sum-query-immutable/
     */
    class NumArray {

        private int[] numsArray;

        public NumArray(int[] nums) {
            int len = nums.length;
            numsArray = new int[len + 1];
            for (int i = 0; i < len; i++) {
                numsArray[i + 1] = nums[i] + numsArray[i];
            }
        }

        public int sumRange(int i, int j) {
            return numsArray[j + 1] - numsArray[i];
        }
    }
//    class NumArray {
//
//        private int[] nums;
//
//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int i, int j) {
//            int sum = 0;
//            for (int index = i; index <= j; index++) {
//                sum += nums[index];
//            }
//            return sum;
//        }
//    }

}

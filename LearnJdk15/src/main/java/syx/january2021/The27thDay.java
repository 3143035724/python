package syx.january2021;

import org.junit.Test;

/**
 * @author syx
 * @version 1.0.0
 * @date 2021/1/27 14:10
 */
public class The27thDay {

    /**
     * 题目： 删除排序数组中的重复项
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/
     */
    public int removeDuplicates(int[] nums) {
        if (nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return 1;
        }
        // 定义初始前后索引
        int suffixIndex = 1;
        // for循环不满足需求
//        for (int index = 0; index < nums.length; index++) {
//            if(nums[index] < nums[suffixIndex]){
//                // 当前值小于后一位的值
//            }
//        }
        int index = 0;
        while (suffixIndex < nums.length) {
            if (nums[index] == nums[suffixIndex]) {
                // 前后值相等，则后续索引+1
                suffixIndex++;
            } else {
                // 前后值不等，则互换位置
                index++;
                nums[index] = nums[suffixIndex];
                suffixIndex++;
            }
        }
        // 不能根据后续索引返回相关值
        return index + 1;
    }

    @Test
    public void test1() {
        int len = removeDuplicates(new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3});
        System.out.println(len);
    }

    /**
     * 题目：给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     */
    @Test
    public void test2() {
        int len = removeElement(new int[]{3, 2, 2, 3}, 3);
        System.out.println(len);
    }

    public int removeElement(int[] nums, int val) {
        if (nums == null) {
            return 0;
        }

        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }
}

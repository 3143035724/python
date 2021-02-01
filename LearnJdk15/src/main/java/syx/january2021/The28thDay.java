package syx.january2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * 数组中重复的数字
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/27 16:11
 */
public class The28thDay {

    /**
     * 题目：数组中重复的数字
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字
     * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
     */
    Map<Integer, Integer> map = new HashMap<>();

    public int findRepeatNumber(int[] nums) {
        int number = -1;
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                return nums[i];
            }
            map.put(nums[i], nums[i]);
        }
        return number;
    }

    /**
     * 题目：寻找数组的中心索引
     * 给定一个整数类型的数组nums，请编写一个能够返回数组 “中心索引” 的方法。
     * 我们是这样定义数组 中心索引 的：数组中心索引的左侧所有元素相加的和等于右侧所有元素相加的和。
     * 如果数组不存在中心索引，那么我们应该返回 -1。如果数组有多个中心索引，那么我们应该返回最靠近左边的那一个。
     * https://leetcode-cn.com/problems/find-pivot-index/
     */
//    public int pivotIndex(int[] nums) {
//        if (nums == null || nums.length == 0) {
//            return -1;
//        }
//        List<Integer> list = new ArrayList<>();
//        for (int num : nums) {
//            list.add(num);
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (addNums(list, 0, i)) {
//                return i;
//            }
//        }
//        return -1;
//    }
//
//    private boolean addNums(List<Integer> addList, int start, int end) {
//        List<Integer> beforeList = addList.subList(start, end);
//        List<Integer> afterList = addList.subList(end + 1, addList.size());
//        int before = 0;
//        int after = 0;
//        for (int i = 0; i < beforeList.size(); i++) {
//            before += beforeList.get(i);
//        }
//        for (int i = 0; i < afterList.size(); i++) {
//            after += afterList.get(i);
//        }
//        return before == after;
//    }
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int after = 0;
        int before = 0;
        for (int num : nums) {
            after += num;
        }
        for (int i = 0; i < nums.length; i++) {
            after -= nums[i];
            if (after == before) {
                return i;
            }
            before += nums[i];
        }
        return -1;
    }


    @Test
    public void test2() {
        pivotIndex(new int[]{1, 7, 3, 6, 5, 6});
    }

    /**
     * 题目：搜索插入位置
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * 假设数组中无重复元素。
     * https://leetcode-cn.com/problems/search-insert-position/submissions/
     */
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {            return 0;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) {
                return i;
            }
        }
        return nums.length;
    }

    @Test
    public void test3() {
        searchInsert(new int[]{1, 3, 5, 6}, 5);
    }
}

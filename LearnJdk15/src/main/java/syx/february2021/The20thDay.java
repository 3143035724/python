package syx.february2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/20 9:43
 */
public class The20thDay {

    /**
     * 题目：移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * 要求：
     * 1、必须在原数组上操作，不能拷贝额外的数组
     * 2、尽量减少操作次数
     * 相关标签：数组、双指针
     * https://leetcode-cn.com/problems/move-zeroes/
     */

    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        // 初始替换位置
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (count != i) {
                    // 将count位置值与i位置值进行互换
                    nums[count] = nums[i];
                    nums[i] = 0;
                }
                count++;
            }
        }
    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 0, 5, 0, 10};
        moveZeroes(nums);
        System.out.println(nums);
    }

    /**
     * 题目：数组的度 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值
     * 在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
     * 题解：获取出现元素最多的初始位置和末尾位置的长度
     * 相关标签：数组
     * https://leetcode-cn.com/problems/degree-of-an-array/
     */
    public int findShortestSubArray(int[] nums) {
        // key为值，value为出现的次数
        Map<Integer, Integer> map = new HashMap<>();
        // 初始化连续出现的频数为0
        AtomicInteger frequency = new AtomicInteger();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.replace(nums[i], map.get(nums[i]), map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
            frequency.set(Math.max(frequency.get(), map.get(nums[i])));
        }

        // 获取map中该数量对应的key值
        Set<Integer> values = getMapKey(map, frequency);
        // key为值，value为对应下标集合
        Map<Integer, List<Integer>> mapValues = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (values.contains(nums[i])) {
                // 数量相同的数字集合
                if (!mapValues.containsKey(nums[i])) {
                    mapValues.put(nums[i], new ArrayList<>());
                }
                mapValues.get(nums[i]).add(i);
            }
        }
        AtomicInteger minValue = new AtomicInteger();
        mapValues.forEach((number, frequencyCounts) -> {
            int min = frequencyCounts.get(0);
            int max = frequencyCounts.get(frequencyCounts.size() - 1);
            if (minValue.get() == 0) {
                minValue.set(max - min);
            }
            minValue.set(Math.min(max - min, minValue.get()));
        });
        return minValue.get() + 1;
    }

    public Set<Integer> getMapKey(Map<Integer, Integer> map, AtomicInteger frequency) {
        Set<Integer> set = new HashSet<>();
        map.forEach((number, count) -> {
            if (count == frequency.get()) {
                set.add(number);
            }
        });
        return set;
    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(findShortestSubArray(nums));
    }

}

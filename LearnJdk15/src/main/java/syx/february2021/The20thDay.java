package syx.february2021;

import org.junit.Test;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/20 9:43
 */
public class The20thDay {

    /**
     * 题目：给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * 要求：
     * 1、必须在原数组上操作，不能拷贝额外的数组
     * 2、尽量减少操作次数
     * 相关标签：数组、双指针
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
    public void test() {
        int[] nums = {1, 2, 0, 5, 0, 10};
        moveZeroes(nums);
        System.out.println(nums);
    }

}

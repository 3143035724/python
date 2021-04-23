package syx.april2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * syx.april2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/4/23 下午 1:47
 */
public class The23thDay {
    /**
     * 题目： 34.在排序数组中查找元素的第一个和最后一个位置
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * 相关标签：数组、二分查找
     * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/
     * 参考：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/comments/906588
     */
    public int[] searchRange(int[] nums, int target) {
        int start = -1;
        int end = -1;
        if (nums != null && nums.length > 0) {
            if (nums.length == 1 && nums[0] == target) {
                start = 0;
                end = 0;
            }
            int index = get(nums, target);
            if (index != -1) {
                start = index;
                end = index;
                while (start - 1 > 0 && nums[start - 1] == target) {
                    start--;
                }
                while (end + 1 < nums.length && nums[end + 1] == target) {
                    end++;
                }
            }
        }
        return new int[]{start, end};
    }

    private int get(int[] nums, int target) {
        int position = -1;
        int start = 0;
        int end = nums.length - 1;
        if (nums[start] <= target) {
            if (nums[start] == target) {
                position = start;
            }
            if (position == -1 && nums[end] >= target) {
                if (nums[end] == target) {
                    position = end;
                }
                while (position == -1 && start <= end) {
                    int middle = (start + end) / 2;
                    if (nums[middle] == target) {
                        position = middle;
                    } else {
                        if (nums[middle] > target) {
                            // 降低高限制，
                            end = middle - 1;
                        } else {
                            start = middle + 1;
                        }
                    }
                }
            }
        }
        return position;
    }
}

package syx.arithmetic;

import java.util.HashMap;
import java.util.Map;

/**
 * * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/15 9:51
 */
//https://leetcode-cn.com/problems/two-sum/
public class Sum {

    public int[] twoSum(int[] nums, int target) {

        int[] indexs = {};
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                indexs = new int[]{i, map.get(target - nums[i])};
            }
            map.put(nums[i], i);
        }
        return indexs;
    }


}

package syx.may2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * * syx.may2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/5/17 下午 6:02
 */
public class The17th1Day {

    private static int max = Integer.MIN_VALUE;

    /**
     * 题目：11.盛最多水的容器
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水
     * 相关标签：数组、双指针
     */
    public int maxArea(int[] height) {
        int max = Integer.MIN_VALUE;
        if (height == null || height.length <= 1) {
            return 0;
        }
        int i = 0, j = height.length - 1;
        while (i < j) {
            int endHigh = Math.min(height[j], height[i]);
            max = Math.max(max, endHigh * (j - i));
            if (height[i] > height[j]) {
                --j;
            } else {
                ++i;
            }
        }
        return max;
    }
//    public int maxArea(int[] height) {
//        int max = Integer.MIN_VALUE;
//        if (height == null || height.length <= 1) {
//            return 0;
//        }
//        for (int i = 0; i < height.length; i++) {
//            for (int j = i + 1; j < height.length; j++) {
//                int endHigh = height[j];
//                max = Math.max(max, (j - i) * Math.min(endHigh, height[i]));
//            }
//        }
//        return max;
//    }

    @Test
    public void test() {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}

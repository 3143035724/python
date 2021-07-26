package syx.may2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * * syx.may2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/5/21 上午 10:34
 */
public class The21thDay {
    /**
     * 题目：4.寻找两个正序数组的中位数
     * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。
     * 相关标签：数组、二分查找、分治算法
     * <p>
     * https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0D;
        int[] sumNumbers = new int[nums1.length + nums2.length];
        int index = 0;
        for (int i : nums1) {
            sumNumbers[index] = i;
            index++;
        }
        for (int i : nums2) {
            sumNumbers[index] = i;
            index++;
        }
        if (index == 0) {
            return result;
        }
        Arrays.sort(sumNumbers);
        // 奇数长度
        index = index - 1;
        int middle = index / 2;
        if (index % 2 == 1) {
            result = (double) (sumNumbers[middle] + sumNumbers[middle + 1]) / 2;
        } else {
            result = sumNumbers[middle];
        }
        return result;
    }

    @Test
    public void test() {
//        findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        String s1 = new String("aaa");
        String s2 = new String("aaa");
        System.out.println(s1 == s2);

        String s3 = s1.intern();
        System.out.println(s1.intern() == s3);
        System.out.println(s1 == s3);
        System.out.println(s2 == s3);

    }


}

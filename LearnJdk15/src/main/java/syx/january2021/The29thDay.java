package syx.january2021;

import org.junit.Test;

/**
 * * syx.january2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/28 14:53
 */
public class The29thDay {

    /**
     * 外观数列
     * 给定一个正整数 n ，输出外观数列的第 n 项。
     * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
     * 你可以将其视作是由递归公式定义的数字字符串序列：
     * countAndSay(1) = "1"
     * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
     * https://leetcode-cn.com/problems/count-and-say/
     */
    public String countAndSay(int n) {
        if (n == 1) return 1 + "";
        String countAndSay = countAndSay(n - 1);
        StringBuffer buffer = new StringBuffer();
        int sum = 1;
        for (int i = 0; i < countAndSay.length(); i++) {
            if (i == countAndSay.length() - 1 || countAndSay.charAt(i) != countAndSay.charAt(i + 1)) {
                buffer.append(sum).append(countAndSay.charAt(i));
                // 将sum重新初始化，防止错误累加
                sum = 1;
            } else {
                sum++;
            }
        }
        return buffer.toString();
    }

    @Test
    public void test1() {
        System.out.println(countAndSay(6));
    }

    /**
     * 题目：给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * [-2,1,-3,4,-1,2,1,-5,4]
     * 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * https://leetcode-cn.com/problems/maximum-subarray/
     */
    public int maxSubArray(int[] nums) {
        // 存储最大和的数据
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            // 两数累加，取其中最大致
            sum = Math.max(sum + num, num);
            max = Math.max(max, sum);
        }
        return max;
    }

    /**
     * 题目：给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
     * 如果不存在最后一个单词，请返回 0 。
     * https://leetcode-cn.com/problems/length-of-last-word/
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int count = 0;
        for (int length = s.length() - 1; length >= 0; length--) {
            if (s.charAt(length) != ' ') {
                count++;
            } else if (count != 0) {
                return count;
            }
        }
        return count;
    }

    @Test
    public void test2() {
        System.out.println(lengthOfLastWord("      "));
    }
}

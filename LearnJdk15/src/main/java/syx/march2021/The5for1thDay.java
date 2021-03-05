package syx.march2021;

/**
 * @author syx
 * @version 1.0.0
 * @date 2021/3/5 11:04
 */
public class The5for1thDay {

    /**
     * 题目：最长回文子串
     * 相关标签：字符串、动态规划
     * https://leetcode-cn.com/problems/longest-palindromic-substring/
     */
    public String longestPalindrome(String s) {
        // 动态规划
        if (s == null || s.length() <= 1) {
            return s;
        }
        int start = 0;
        int end = s.length();
        int[] indexs = new int[2];

        char[] chars = s.toCharArray();

        for (int index = 0; index < s.length(); index++) {
            index = find(chars, indexs, index);
        }

        return s.substring(indexs[0], indexs[1] + 1);
    }

    public static int find(char[] chars, int[] indexs, int nowIndex) {

        int endIndex = nowIndex;
        while (endIndex < chars.length - 1 && chars[nowIndex] == chars[endIndex + 1]) {
            endIndex++;
        }
        // 跳出循环时结束索引为下一次循环开始的起始位置
        int middleIndex = endIndex;
        while (nowIndex > 0 && endIndex < chars.length - 1 && chars[nowIndex - 1] == chars[endIndex + 1]) {
            // 当相等时各自向两边移动，扩散
            endIndex++;
            nowIndex--;
        }
        // 如果长度更新，替换索引数组中的位置
        if (endIndex - nowIndex > indexs[1] - indexs[0]) {
            indexs[0] = nowIndex;
            indexs[1] = endIndex;
        }
        return middleIndex;
    }
}

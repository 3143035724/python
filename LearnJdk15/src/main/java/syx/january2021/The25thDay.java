package syx.january2021;

import org.junit.Test;

import java.util.Arrays;

/**
 * * https://leetcode-cn.com/problems/longest-common-prefix/
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/25 16:52
 */
public class The25thDay {

    /**
     * 题目：编写一个函数来查找字符串数组中的最长公共前缀
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * https://leetcode-cn.com/problems/longest-common-prefix/
     */
    public static String prefix = "";


//    public String longestCommonPrefix(String[] strs) {
//        if (strs.length == 0) {
//            return "";
//        }
//
//        int end = Arrays.stream(strs).mapToInt(String::length).min().getAsInt();
//        prefix = strs[0].substring(0, end);
//        for (int i = 0; i < strs.length; i++) {
//            if (!strs[i].startsWith(prefix.toString())) {
//                if (end == 0) {
//                    i = strs.length;
//                    continue;
//                }
//                end--;
//                prefix = prefix.substring(0, end);
//                i = 0;
//            }
//        }
//        if (end == 0) {
//            return "";
//        }
//        return prefix.substring(0, end);
//    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        prefix = strs[0];
        int end = prefix.length();
        for (int i = 0; i < strs.length; i++) {
            // 如果当前字符串的长度比最短值小，对其进行重新赋值
            if (strs[i].length() < end) {
                end = strs[i].length();
                prefix = prefix.substring(0, end);
            }
            if (!strs[i].startsWith(prefix)) {
                if (end == 0) {
                    i = strs.length;
                    continue;
                }
                end--;
                prefix = prefix.substring(0, end);
                i = 0;
            }
        }
        if (end == 0) {
            return "";
        }
        return prefix.substring(0, end);
    }


    @Test
    public void test() {
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));
    }
}

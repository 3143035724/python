package syx.may2021;

import org.junit.Test;

/**
 * * syx.may2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/5/18 下午 4:10
 */
public class The19thDay {

    /**
     * 题目：8. 字符串转换整数 (atoi)
     * 相关标签：数字、字符串
     * <p>
     * https://leetcode-cn.com/problems/string-to-integer-atoi/
     */

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int number = 0;
        int length = s.length();
        while (number < length && chars[number] == ' ') {
            number++;
        }
        if (number == length) {
            return 0;
        }
        int flag = 1;
        char first = chars[number];
        if (first == '+') {
            number++;
        } else if (first == '-') {
            flag = -1;
            number++;
        }
        int result = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (number < length) {
            char currChar = chars[number];
            // 判断数字合法性
            if (currChar > '9' || currChar < '0') {
                break;
            }
            if (result > max / 10 || (result == max / 10 && (currChar - '0') > max % 10)) {
                return flag > 0 ? max : min;
            }
            result = result * 10 + (currChar - '0');
            number++;
        }
        return flag > 0 ? result : flag * result;
    }


    @Test
    public void test() {
        int i = myAtoi("-91283472332");
        System.out.println(i);
    }

}

package syx.arithmetic;

/**
 * * 整数反转
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/15 15:21
 */
//https://leetcode-cn.com/problems/reverse-integer/
public class Solution {

    public static int reverse(int x) {
        long n = 0;
        while (x != 0) {
            n = n * 10 + x % 10;
            x = x / 10;
        }
        return (int) n == n ? (int) n : 0;
    }

    public static void main(String[] args) {

        reverse(123);
    }
}

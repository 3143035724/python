package syx.arithmetic;

import org.junit.Test;

/**
 * * 判断一个数字是不是回文数
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/18 14:33
 */
public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        // 将数字转换为字符串
        String xStr = x + "";

        if (xStr.length() == 1) {
            return true;
        }
        for (int i = 0; i < xStr.length(); i++) {
            if (xStr.charAt(i) != xStr.charAt(xStr.length() - i - 1)) {
                return false;
            }
        }

        return true;
    }

    @Test
    public void test() {
        isPalindromeTwo(121);
    }

    public boolean isPalindromeTwo(int x) {
        // 不进行字符串的转换
        if (x < 0) {
            return false;
        }
        int reversalNumber = 0;
        int tempNumber = x;

        while (tempNumber != 0) {
            reversalNumber = tempNumber % 10 + reversalNumber * 10;
            tempNumber = tempNumber / 10;
        }

        return reversalNumber == x;
    }

}

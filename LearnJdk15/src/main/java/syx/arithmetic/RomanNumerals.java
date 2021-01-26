package syx.arithmetic;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * * 罗马数字转整数
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/18 14:57
 */
public class RomanNumerals {

    private static final Map<Character, Integer> map = new HashMap<>();

    private static void init() {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        init();
        int result = 0;
        if (Objects.isNull(s)) {
            return result;
        }
        for (int i = 0; i < s.length(); i++) {
            int iNum = map.get(s.charAt(i));
            if (i != s.length() - 1 && iNum < map.get(s.charAt(i + 1))) {
                result -= iNum;
            } else {
                result += iNum;
            }
        }
        return result;
    }


    @Test
    public void test() {
        // 399
        System.out.println(System.currentTimeMillis());
        System.out.println(romanToInt("CCCXCIX"));
        System.out.println(System.currentTimeMillis());
    }

}

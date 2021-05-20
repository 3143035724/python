package syx.may2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * * syx.may2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/5/20 上午 11:08
 */
public class The20thDay {

    /**
     * 题目：电话号码的字母组合
     * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回
     * 相关标签：深度优先搜索、递归、字符串、回溯算法
     * <p>
     * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
     */

    private static Map<Character, List<String>> map = new HashMap<>();

    private static void init() {
        map.put('2', Arrays.asList("a", "b", "c"));
        map.put('3', Arrays.asList("d", "e", "f"));
        map.put('4', Arrays.asList("g", "h", "i"));
        map.put('5', Arrays.asList("j", "k", "l"));
        map.put('6', Arrays.asList("m", "n", "o"));
        map.put('7', Arrays.asList("p", "q", "r", "s"));
        map.put('8', Arrays.asList("t", "u", "v"));
        map.put('9', Arrays.asList("w", "x", "y", "z"));
    }

    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return list;
        }
        int start = 0;
        int length = digits.length();
        char[] chars = digits.toCharArray();
        while (start < length && chars[start] == ' ') {
            start++;
        }
        // 去除极端情况
        if (start == length) {
            return list;
        }
        init();
        getNumbers(list, chars, start, new StringBuilder());
        return list;
    }

    private void getNumbers(List<String> list, char[] chars, int index, StringBuilder builder) {
        if (index == chars.length) {
            list.add(builder.toString());
        } else {
            List<String> strings = map.get(chars[index]);
            for (String string : strings) {
                builder.append(string);
                getNumbers(list, chars, index + 1, builder);
                // 删除刚刚新增的一个，确保下一次循环不会将上一次添加的结果带入
                builder.deleteCharAt(index);
            }
        }
    }

    @Test
    public void test() {
        letterCombinations("23");
    }

}

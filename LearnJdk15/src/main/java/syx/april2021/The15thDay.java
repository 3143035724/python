package syx.april2021;

import java.util.Stack;

/**
 * * syx.april2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/4/14 下午 4:22
 */
public class The15thDay {
    /**
     * 题目：1047. 删除字符串中的所有相邻重复项
     * 标签：栈
     * https://leetcode-cn.com/problems/remove-all-adjacent-duplicates-in-string/
     */

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new The15thDay().removeDuplicates(s));
    }

    public String removeDuplicates(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peek().equals(s.charAt(i))) {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.reverse().toString();
    }

}

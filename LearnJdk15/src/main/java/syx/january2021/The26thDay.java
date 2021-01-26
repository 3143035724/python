package syx.january2021;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * *
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/26 9:08
 */
public class The26thDay {

    /**
     * https://leetcode-cn.com/problems/valid-parentheses/
     * 题目：给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 输入：s =([)]
     * 输出：false
     */

    private static Map<Character, Character> map = new HashMap<>();

    private void initMap() {
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
    }


    public boolean isValid(String s) {

        if (s.length() == 0) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }

        // 栈：后进先出
        Stack<Character> stack = new Stack<>();
        initMap();

        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))) {
                    return false;
                }
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
        }


        return stack.empty();
    }

    @Test
    public void test1() {
        System.out.println(isValid("){"));
    }


    /**
     * 题目：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     * https://leetcode-cn.com/problems/merge-two-sorted-lists/submissions/
     */

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode treeNode = new ListNode();
        if (l1 == null || l2 == null) {
            treeNode.next = l1 == null ? l2 : l1;
            return treeNode.next;
        }

        ListNode node = treeNode;

        while (l1 != null || l2 != null) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            if (val1 < val2) {
                if (l1 != null) {
                    node.next = new ListNode(val1);
                    l1 = l1.next;
                } else {
                    node.next = new ListNode(val2);
                    l2 = l2.next;
                }
            } else {
                if (l2 != null) {
                    node.next = new ListNode(val2);
                    l2 = l2.next;
                } else {
                    node.next = new ListNode(val1);
                    l1 = l1.next;
                }
            }
            node = node.next;
        }

        return treeNode.next;
    }

    @Test
    public void test2() {
        mergeTwoLists(new ListNode(1), new ListNode(2));
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


}

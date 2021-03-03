package syx.february2021;

import org.junit.Test;

import java.math.BigDecimal;

/**
 * *
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/1 11:34
 */
public class The3thDay {

    /**
     * 题目：加一
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * https://leetcode-cn.com/problems/plus-one/
     */
    public int[] plusOne(int[] digits) {
        for (int length = digits.length - 1; length >= 0; length--) {
            digits[length]++;
            digits[length] = digits[length] % 10;
            if (digits[length] != 0) {
                // 不存在进位
                return digits;
            }
        }
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }

    @Test
    public void test1() {
        plusOne(new int[]{0});
    }

    /**
     * 题目：反转链表
     * 输入：1->2->3->4->5->NULL
     * 输出：5->4->3->2->1->NULL
     * https://leetcode-cn.com/problems/reverse-linked-list/submissions/
     */

    public ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        // 遍历当前节点的下一节点
        ListNode node = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的node就是5
        // node是5,则head就是4,4.next.next=5.next=4
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        // 设置下一个节点，防止重复循环消费
        head.next = null;
        return node;
    }

    @Test
    public void test2() {
        reverseList(new ListNode(1, new ListNode(2, new ListNode(4))));
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

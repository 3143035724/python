package syx.march2021;

import org.junit.Test;

import java.util.Stack;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/5 15:26
 */

public class The5for2thDay {

    /**
     * 题目：给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点
     * 相关标签：链表、双指针
     * 参考：LinkedList添加元素原理
     * https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || (head.next == null && n == 1)) {
            return null;
        }
        int size = 0;

        ListNode node = head;
        // 获取当前节点有多少元素，好判断后续链表断裂的条件
        while (node != null) {
            size++;
            node = node.next;
        }
        size = size - n;
        // 当count为0时，证明移除的是第一个元素，则直接将指针指向修改即可
        if (size == 0) {
            head = head.next;
            return head;
        }
        int count = 0;
        ListNode listNode = head;
        while (listNode != null) {
            count++;
            if (count == size) {
                listNode.next = listNode.next.next;
            }
            listNode = listNode.next;
        }
        return head;
    }

    @Test
    public void test() {
        removeNthFromEnd(new ListNode(1, new ListNode(2)), 2);
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

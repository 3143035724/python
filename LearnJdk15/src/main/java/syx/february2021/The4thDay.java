package syx.february2021;

import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/4 9:49
 */
public class The4thDay {

    /**
     * 题目：用队列实现栈
     * 使用两个队列实现一个后入先出（LIFO）的栈，并支持普通队列的全部四种操作（push、top、pop 和 empty）
     * 实现 MyStack 类：
         * void push(int x) 将元素 x 压入栈顶
         * int pop() 移除并返回栈顶元素。
         * int top() 返回栈顶元素
         * boolean empty() 如果栈是空的，返回 true ；否则，返回 false
     * 特性请参考类LearnLinkedList
     * https://leetcode-cn.com/problems/implement-stack-using-queues/
     */

    @Test
    public void test1() {
        MyStack obj = new MyStack();
        obj.push(1);
        obj.push(2);
        obj.push(3);
        int param_2 = obj.top();
        int param_3 = obj.pop();
        boolean param_4 = obj.empty();
    }
}


class MyStack {

    Queue<Integer> queue;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        // offer(E e)：在链表尾部插入一个元素
        queue.offer(x);

        for (int i = 0; i < queue.size() - 1; i++) {
            // 边移除边放置
            queue.offer(queue.poll());
        }
    }

    /**
     * 移除第一个元素，并返回第一个元素
     */
    public int pop() {
        // poll()：查询并移除第一个元素
        return queue.poll();
    }

    /**
     * 获取第一个元素
     */
    public int top() {
        // peek()：获取第一个元素，但是不移除；
        return queue.peek();
    }

    /**
     * 判断栈是否为空
     */
    public boolean empty() {
        return queue.isEmpty();
    }
}

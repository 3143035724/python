package syx.march2021;

import org.junit.Test;

import java.util.Stack;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/5 9:14
 */
public class The5thDay {

    /**
     * 题目：用栈实现队列
     */
    class MyQueue {


        private Stack<Integer> stack;

        /**
         * Initialize your data structure here.
         */
        public MyQueue() {
            this.stack = new Stack<>();
        }

        /**
         * Push element x to the back of queue.
         */
        public void push(int x) {
            stack.push(x);
        }

        /**
         * Removes the element from in front of queue and returns that element.
         */
        public int pop() {
            reversal();
            Integer pop = stack.pop();
            reversal();
            return pop;
        }

        /**
         * Get the front element.
         */
        public int peek() {
            reversal();
            Integer peek = stack.peek();
            reversal();
            return peek;
        }

        /**
         * Returns whether the queue is empty.
         */
        public boolean empty() {
            return stack.isEmpty();
        }

        private void reversal() {
            Stack<Integer> copyStack = new Stack<>();
            while (!stack.isEmpty()) {
                copyStack.push(stack.pop());
            }
            this.stack = copyStack;
        }
    }

    @Test
    public void test() {
        MyQueue queue = new MyQueue();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        queue.push(4);
        System.out.println(queue.pop());
        queue.push(5);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

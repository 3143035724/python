package syx.march2021;

/**
 * * syx.march2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/3/14 下午 5:29
 */
public class The14thDay {
    /**
     * 题目：不使用任何内建的哈希表库设计一个哈希集合（HashSet）
     * https://leetcode-cn.com/problems/design-hashmap/
     */
    class MyHashSet {

        private boolean[] sets = new boolean[1000005];

        /**
         * Initialize your data structure here.
         */
        public MyHashSet() {

        }

        public void add(int key) {
            sets[key] = true;
        }

        public void remove(int key) {
            sets[key] = false;
        }

        /**
         * Returns true if this set contains the specified element
         */
        public boolean contains(int key) {
            return sets[key];
        }
    }
}

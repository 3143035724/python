package syx.february2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/22 10:10
 */
public class The22thDay {
    /**
     * 题目：托普利茨矩阵
     * 给你一个 m x n 的矩阵 matrix 。如果这个矩阵是托普利茨矩阵，返回 true ；否则，返回 false
     * 如果矩阵上每一条由左上到右下的对角线上的元素都相同，那么这个矩阵是 托普利茨矩阵
     * 相关标签：数组
     * https://leetcode-cn.com/problems/toeplitz-matrix/submissions/
     */
    class A {
        public boolean isToeplitzMatrix(int[][] matrix) {
            for (int i = 0; i < matrix.length; i++) {
                for (int i1 = 0; i1 < matrix[0].length; i1++) {
                    if (i < matrix.length - 1 && i1 < matrix[0].length - 1 && matrix[i][i1] != matrix[i + 1][i1 + 1]) {
                        return false;
                    }
                }
            }
            return true;
        }
    }

    @Test
    public void testA() {
        System.out.println(new A().isToeplitzMatrix(new int[3][4]));
    }

    /**
     * 题目：无重复字符的最长子串
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度
     * 相关标签：哈希表、双指针、字符串、Sliding Window(滑动窗口算法)
     * https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
     */
    class B {

        public int lengthOfLongestSubstring(String s) {
            if (s == null) {
                return 0;
            }
            if (s.length() <= 1) {
                return s.length();
            }
            int start = 0;
            int maxLength = 0;
            // key为指定索引位置的字符，value为对应索引
            Map<Character, Integer> map = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                // abcabcbb，注意：map存放的值也一直在发生变化，对应的index下标变化
                // 思路：    map长度  start   maxLength,比较值
                // 第一次：  1        0       1,1
                // 第二次：  2        0       2,2
                // 第三次：  3        0       3,3
                // 第四次：  3        1,2     3,3  此时结束后，map对应数据为a->3,b->4,c->2
                // 第五次：  3        2,3     3,3  此时结束后，map对应数据为a->3,b->4,c->5
                // 第六次：  3        3,5     3,2  此时结束后，map对应数据为a->3,b->6,c->5
                // 第七次：  3        5       3,1 此时结束后，map对应数据为a->3,b->7,c->5
                if (map.containsKey(s.charAt(i))) {
                    // 刷新左侧位置，加1是因为索引下标要跳过当前位置的字符，需要将索引下标移动到后面一个位置
                    start = Math.max(start, map.get(s.charAt(i)) + 1);
                }
                map.put(s.charAt(i), i);
                maxLength = Math.max(maxLength, i + 1 - start);
            }
            return maxLength;
        }
    }

    @Test
    public void testB() {
        System.out.println(new B().lengthOfLongestSubstring("abcabcbb"));
    }
}

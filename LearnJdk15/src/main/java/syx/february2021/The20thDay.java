package syx.february2021;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * * syx.february2021
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/2/20 9:43
 */
public class The20thDay {

    /**
     * 题目：移动零 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序
     * 要求：
     * 1、必须在原数组上操作，不能拷贝额外的数组
     * 2、尽量减少操作次数
     * 相关标签：数组、双指针
     * https://leetcode-cn.com/problems/move-zeroes/
     */
    class A {

        public void moveZeroes(int[] nums) {
            if (nums == null || nums.length == 0) {
                return;
            }
            // 初始替换位置
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != 0) {
                    if (count != i) {
                        // 将count位置值与i位置值进行互换
                        nums[count] = nums[i];
                        nums[i] = 0;
                    }
                    count++;
                }
            }
        }


    }

    @Test
    public void test1() {
        int[] nums = {1, 2, 0, 5, 0, 10};
        new A().moveZeroes(nums);
        System.out.println(nums);
    }

    /**
     * 题目：数组的度 给定一个非空且只包含非负数的整数数组 nums，数组的度的定义是指数组里任一元素出现频数的最大值
     * 在 nums 中找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度
     * 题解：获取出现元素最多的初始位置和末尾位置的长度
     * 相关标签：数组
     * https://leetcode-cn.com/problems/degree-of-an-array/
     */
    class B {
        public int findShortestSubArray(int[] nums) {
            // key为值，value为出现的次数
            Map<Integer, Integer> map = new HashMap<>();
            // 初始化连续出现的频数为0
            AtomicInteger frequency = new AtomicInteger();

            for (int num : nums) {
                if (map.containsKey(num)) {
                    map.replace(num, map.get(num), map.get(num) + 1);
                } else {
                    map.put(num, 1);
                }
                frequency.set(Math.max(frequency.get(), map.get(num)));
            }

            // 获取map中该数量对应的key值
            Set<Integer> values = getMapKey(map, frequency);
            // key为值，value为对应下标集合
            Map<Integer, List<Integer>> mapValues = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                if (values.contains(nums[i])) {
                    // 数量相同的数字集合
                    if (!mapValues.containsKey(nums[i])) {
                        mapValues.put(nums[i], new ArrayList<>());
                    }
                    mapValues.get(nums[i]).add(i);
                }
            }
            AtomicInteger minValue = new AtomicInteger();
            mapValues.forEach((number, frequencyCounts) -> {
                int min = frequencyCounts.get(0);
                int max = frequencyCounts.get(frequencyCounts.size() - 1);
                if (minValue.get() == 0) {
                    minValue.set(max - min);
                }
                minValue.set(Math.min(max - min, minValue.get()));
            });
            return minValue.get() + 1;
        }

        public Set<Integer> getMapKey(Map<Integer, Integer> map, AtomicInteger frequency) {
            Set<Integer> set = new HashSet<>();
            map.forEach((number, count) -> {
                if (count == frequency.get()) {
                    set.add(number);
                }
            });
            return set;
        }

    }

    @Test
    public void test2() {
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(new B().findShortestSubArray(nums));
    }

    /**
     * 题目：合并两个有序数组  给你两个有序整数数组 nums1 和 nums2，请你将 nums2 合并到 nums1 中，使 nums1 成为一个有序数组
     * 初始化nums1 和 nums2 的元素数量分别为 m 和 n 。你可以假设 nums1 的空间大小等于 m + n，这样它就有足够的空间保存来自 nums2 的元素
     * 相关标签：数组、双指针
     * https://leetcode-cn.com/problems/merge-sorted-array/submissions/
     * TODO
     */
    class C {
//        public void merge(int[] nums1, int m, int[] nums2, int n) {
//            if (m != 0 && n != 0) {
//                // 将nums2中的数据全部放至nums1
//                // 对nums1中数据进行排序
//                int countIndex = 0;
//                for (int i = m; i < nums1.length; i++) {
//                    if (nums1[i] == 0) {
//                        nums1[i] = nums2[countIndex];
//                        countIndex++;
//                    }
//                }
//                for (int i = 0; i < nums1.length; i++) {
//                    if (i != 0 && nums1[i - 1] > nums1[i]) {
//                        // 如果当前值 > 后续值，需要进行位置互换
//                        int temp = nums1[i - 1];
//                        nums1[i - 1] = nums1[i];
//                        nums1[i] = temp;
//                        i = 0;
//                    }
//                }
//            } else {
//                // 当只有数组2有数据时，将数组2的数据赋值给数组1
//                if (m == 0) {
//                    nums1 = new int[n];
//                    for (int i = 0; i < nums2.length; i++) {
//                        nums1[i] = nums2[i];
//                    }
//                }
//            }
//        }

        public void merge(int[] nums1, int m, int[] nums2, int n) {
            // 方法2，官方解答思路
            // 拷贝nums1的数据至nums1_copy数组
            int[] nums1Copy = new int[m];
            System.arraycopy(nums1, 0, nums1Copy, 0, m);

            // p1为拷贝数组的指针、p2为nums2的指针、p为nums1本身的指针
            int p1 = 0;
            int p2 = 0;

            // Set pointer for nums1
            int p = 0;

            // 替换nums1中的数据，将拷贝的数据与nums2进行比较
            while ((p1 < m) && (p2 < n)) {
                nums1[p++] = (nums1Copy[p1] < nums2[p2]) ? nums1Copy[p1++] : nums2[p2++];
            }

            // src      the source array. 源数组
            // srcPos   starting position in the source array. 源数组的起始位置
            //  dest     the destination array. 目标数组
            //  destPos  starting position in the destination data. 目标数组的起始位置
            //  length   the number of array elements to be copied. 复制的长度
            // 如果拷贝指针p1未移除至拷贝数组尾端，则需要将拷贝数组剩余部分进行赋值
            if (p1 < m) {
                System.arraycopy(nums1Copy, p1, nums1, p1 + p2, m + n - p1 - p2);
            }
            // 如果指针p2未移除至nums2数组尾端，则需要将nums2数组剩余部分进行赋值
            if (p2 < n) {
                System.arraycopy(nums2, p2, nums1, p1 + p2, m + n - p1 - p2);
            }
        }
    }

    @Test
    public void test3() {
        int[] nums1 = {-1, 0, 0, 3, 3, 3, 0, 0, 0};
        int m = 6;
        int[] nums2 = {1, 2, 2};
        int n = 3;
        new C().merge(nums1, m, nums2, n);
        System.out.println(nums1);
    }

    /**
     * 题目：环形链表
     * 给定一个链表，如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况
     * 如果链表中存在环，则返回 true 。 否则，返回 false
     * 相关标签：链表、双指针
     * https://leetcode-cn.com/problems/linked-list-cycle/
     */
    class D {
        public boolean hasCycle(ListNode head) {
            if (head == null || head.next == null) {
                return false;
            }
            ListNode copyHead = head;
            Set<ListNode> vals = new HashSet<>();
            while (copyHead != null) {
                if (!vals.add(copyHead)) {
                    return true;
                }
                copyHead = copyHead.next;
            }
            return false;
        }
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test4() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        new D().hasCycle(listNode);
    }


}

package syx.arithmetic;

/**
 * * 两数相加
 *
 * @author syx
 * @version 1.0.0
 * @date 2021/1/18 11:16
 */
public class TwoTogether {
    //    https://leetcode-cn.com/problems/add-two-numbers/
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 定义根节点
        ListNode rootNode = new ListNode(0);

        ListNode node = rootNode;
        // 定义十位数所在数值
        int tensNum = 0;
        while (l1 != null || l2 != null || tensNum != 0) {
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            // 节点相加值，需要将上一次计算的十位数所在数值进行加入
            int number = val1 + val2 + tensNum;
            // 比如val1=7，val2=8，则number=15，tensNum=1，number=5
            tensNum = number / 10;
            number = number % 10;

            // 后续进行赋值
            node.next = new ListNode(number);
            node = node.next;

            // 遍历后续值
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        return rootNode.next;
    }

    //    题目给出的数据
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

package mid;

/**
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
public class LeetCode2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    static class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int first = 0, last = 0;
            ListNode result = new ListNode(0);
            ListNode listNode = result;
            // 以长度短的链表为边界，计算两个链表值的和
            while (l1 != null && l2!= null) {
                first = (l1.val + l2.val + last) % 10;
                listNode.next = new ListNode(first);
                last = (l1.val + l2.val + last) / 10;
                listNode = listNode.next;
                l1 = l1.next;
                l2 = l2.next;

            }
            // 计算剩余的链表
            ListNode temp;
            if (l1 != null) {
                temp = l1;
            } else {
                temp = l2;
            }
            while (temp != null) {
                listNode.next = new ListNode((temp.val + last) % 10);
                last = (temp.val + last) / 10;
                listNode = listNode.next;
                temp = temp.next;
            }
            // 处理最后一位
            if(last!=0){
                listNode.next = new ListNode(last);
            }
            return result.next;
        }


    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(7);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(2);
        ListNode l6 = new ListNode(4);
        ListNode l7 = new ListNode(5);
        ListNode l8 = new ListNode(0);
        l1.next = l2;
//        l2.next = l3;
        l4.next = l5;
//        l5.next = l6;
        ListNode listNode = new Solution().addTwoNumbers(l1, l4);
        System.out.println();
    }
}

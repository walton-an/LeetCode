package easy;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 *
 * 输入：head = [1,2,3,4,5]
 * 输出：[5,4,3,2,1]
 *
 * https://leetcode.cn/problems/reverse-linked-list/
 *
 * @author Yangweitong
 * @date 2022/11/21
 */
public class Leetcode206 {

     public static class ListNode {
         int val;
         ListNode next;
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }

    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        ListNode ListNode = reverseList(head);
        System.out.println();
    }

    public static ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            cur = cur.next;
            head.next = pre;
            pre = head;
            head = cur;
        }
        return pre;
    }

}


//leetcode submit region begin(Prohibit modification and deletion)

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;
        ListNode p = head;


        while (p != null) {
            //按照给定值开始分类

            if (p.val < x) {
                //左边小值
                p1.next = p;
                p1 = p1.next;
                //System.out.println("dummy1: " + dummy1.val);

            } else {
                //右边大值
                p2.next = p;
                p2 = p2.next;
                //System.out.println("dummy2: " + dummy2.val);
            }
            //System.out.println("p: " + p.val);
            //Error - Found cycle in the ListNode 断开原链表
            ListNode temp = p.next;
            p.next = null;
            p = temp;

        }

        // 连接两个链表
        p1.next = dummy2.next;

        return dummy1.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

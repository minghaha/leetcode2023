
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return null;
        }


        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //int n = 0;
        //while(dummy != null){
        //    n++;
        //    dummy = dummy.next;
        //}
        //
        //System.out.println("n = " + n);
        //
        //int left = 0;
        //int right = 0;

        //ListNode curr= head;
        //for (int i = 0; i < ; i++) {
        //
        //}

        //左闭又开区间[0,2)
        dummy.next =reverseBetween(dummy.next, 0, 2);
        dummy.next =reverseBetween(dummy.next, 3, 5);
        dummy.next =reverseBetween(dummy.next, 6, 8);
        return  dummy.next;
    }

    ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }

        //记录结果
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //只想要反转那个左节点的前一个节点
        ListNode pre=dummy;
        for (int i = 1; i < left; i++) {
            pre =pre.next;
        }


        //分别记录当前和下一个节点，为反转做准备
        ListNode curr = pre.next;
        ListNode tail = curr.next;
        System.out.println("curr: " + curr.val);
        System.out.println("tail: " + tail.val);

        for (int i = left; i <right-1 ; i++) {
            ListNode next = tail.next;
            tail.next = curr;
            curr = tail;
            tail = next;
        }

        //System.out.println("curr: "+curr.val);
        //System.out.println("tail: "+tail.val);

        //注意操作顺序，否则会导致链表结构问题
        pre.next.next = tail;
        pre.next = curr;

        ListNode dummy2 = dummy;
        while(dummy2!=null) {
            System.out.print("  dummy2:  " + dummy2.val);
            dummy2 = dummy2.next;
        }
        System.out.println();

        return dummy.next;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

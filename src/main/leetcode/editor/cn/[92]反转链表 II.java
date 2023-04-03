
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null || left == right) {
            return head;
        }


        //虚拟节点为了避免头节点为空
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        //分别记录要反转的前节点和要反转的第一个节点
        ListNode currDummy = dummy;
        ListNode prevDummy = null;

        ListNode prev = null;
        ListNode curr = null;

        for (int i = 0; i < left; i++) {
            prevDummy = currDummy;
            currDummy = currDummy.next;
        }
        curr = currDummy;

        //反转范围内的节点
        for (int i = left; i <= right && curr !=null; i++){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        //拼接节点，反转前的结点 拼反转后的头结点
        prevDummy.next = prev;
        //反转后的最后一个节点拼接right后的那个节点
        currDummy.next = curr;


         return dummy.next;

    }


}
//leetcode submit region end(Prohibit modification and deletion)

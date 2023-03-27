
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        int len = 0;
        ListNode dummy = head;
        while (dummy != null) {
            len++;
            dummy = dummy.next;
        }

        int position = len - n+1 -1+1;//要删除的节点的前一个节点,因为添加了一个虚节点，所以在+1
        System.out.println("position: " + position);

        int currPosition = 0;
        ListNode dummy3 = new ListNode(-1);
        dummy3.next = head;
        ListNode dummy2 = dummy3;

        while (dummy2 != null) {
            currPosition++;
            System.out.println("currPosition: " + currPosition);

            if (currPosition == position) {
                System.out.println("dummy2.next: "+dummy2.next.val);
                //System.out.println("dummy2.next.next: "+dummy2.next.next.val);

                dummy2.next = dummy2.next.next;


                return dummy3.next;
            } else {
                dummy2 = dummy2.next;
            }

        }
        return null;

    }
}
//leetcode submit region end(Prohibit modification and deletion)

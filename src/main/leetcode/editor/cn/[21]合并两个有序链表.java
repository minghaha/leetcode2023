
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode newList = dummy;
        merge(list1, list2, dummy);
        return dummy.next;

    }

    void merge(ListNode list1, ListNode list2, ListNode dummy) {


        if (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }

            System.out.println("dummy: " + dummy.val);
            dummy = dummy.next;

            merge(list1, list2, dummy);
            return;

        }

        if (list1 != null) {
            dummy.next = list1;
            System.out.println("dummy-list1: " + dummy.val);
            return;
        }

        if (list2 != null) {
            dummy.next = list2;
            System.out.println("dummy-list2: " + dummy.val);
            return;
        }

    }
}
//leetcode submit region end(Prohibit modification and deletion)

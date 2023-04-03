
//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head==null){
            return false;
        }

        ListNode fastP = head;
        ListNode slowP = head;

        //如果有环一定相遇在环内
        while(fastP!=null && fastP.next!=null){

            fastP = fastP.next.next;
            slowP = slowP.next;
            if(fastP == slowP){
                return true;
            }
        }
        return false;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

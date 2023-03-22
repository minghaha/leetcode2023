
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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists==null || lists.length==0){
            return null;
        }

        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;


        //利用优先级队列，大数都沉下去
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        //PriorityQueue<ListNode> queue = new PriorityQueue<>(
        //        lists.length, (a, b)->(a.val - b.val));



        //放数 放都是每个数组的头节点
        for (ListNode head : lists) {
            if(head!=null){
                pq.add(head);
                //System.out.println(("pq " + head.val));
            }
        }



        //取数构成链表，注意每次取的都是每个链表的头节点，取完记得把当前链表的下一个节点放进去
        while (pq != null && pq.size() != 0) {
            ListNode tempNode = pq.poll();
            p.next = tempNode;
            p = p.next;

            if(tempNode!=null&&tempNode.next!=null){
                pq.add(tempNode.next);
            }

            //System.out.println("p: " + p.val);
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

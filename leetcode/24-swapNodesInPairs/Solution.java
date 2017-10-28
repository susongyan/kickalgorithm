/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead; 
        ListNode node1 = null;
        ListNode node2 = null;
        ListNode next = null;
        while(cur != null && cur.next !=null && cur.next.next != null){
            node1 = cur.next;
            node2 = node1.next;
            next = node2.next;

            cur.next = node2;
            node1.next = next;
            node2.next = node1;

            cur = node1; // 两个相邻节点的位置已经交换了 这是 node1 在后面
        }
        return dummyHead.next;
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
}
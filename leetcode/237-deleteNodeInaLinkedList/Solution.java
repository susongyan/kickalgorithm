/**
 *  单链表，要删除一个元素只能将前一个元素的next指向被删除元素的next，
 *  而本题我们只拿到被删除元素的引用，也就是说我们只能删除 期望被删除元素的下一个元素
 * 
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode next = node.next; // 题目中已经说明node不是尾元素了
        node.val = next.val;
        node.next = next.next; 
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode(int x){ val = x;}
    }
}
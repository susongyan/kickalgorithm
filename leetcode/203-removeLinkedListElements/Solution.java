
 /** 需要注意第一个元素（或者删除操作后成为第一个的元素）值为val的情况        
   * 1 --> 1 --> 6 , val = 1 
   * 
   * 在第一个元素之前 加了一个节点，是为了方便在做删除 prev.next = cur.next 操作的统一性
   * Tn = O(n)
   * Sn = O(1);
   */ 
class Solution {    
    public ListNode removeElements(ListNode head, int val) {
              
        ListNode virtualFirst = new ListNode(0);
        virtualFirst.next = head;
        ListNode prev = virtualFirst;
        ListNode cur = head;
        while(cur != null){            
            if(cur.val == val){
                prev.next = cur.next;               
            }
            else{
                prev = cur; 
            }
            cur = cur.next;
        }
        return virtualFirst.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

class Solution{
    public ListNode reverseList(ListNode head){
        // 主要需要注意 覆盖的问题
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;
        while(cur != null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * 节点
     */
    class ListNode{
        int val;
        ListNode next;
        
        public ListNode(int x){
            this.val = x;
        }
    }
}
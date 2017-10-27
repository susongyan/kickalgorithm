class Solution{
    // iteratively
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

    // recursively
    public static ListNode reverseListRecursively(ListNode head) {
        return reverseListInt(head, null);
    }
      
    private static ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }

    public static ListNode reverseListRecursivly2(ListNode node){
        if(node == null || node.next == null) {
            return node;
        }
        ListNode p  = reverseListRecursivly(node.next);
        node.next.next = node;
        /*
        * 如果没有这一步， 
        *
        *  6 -> 2 -> 1 -> 3 -> 0 会变成
        *  
        *  6 <-  2 <- 1 <- 3 <- 0
        *    ->
        */
        node.next = null; //这步非常重要，如果没有的话原来的第一个元素会形成环
        return p;
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

    public static void main(String[] args) {
        ListNode node = generate();

        printLinkedList(node);

        System.out.println();
        printLinkedList( reverseList(node));
    }

    private static void printLinkedList(ListNode node) {
        ListNode cur = node;
        while (cur != null) {
            System.out.print(cur.val + " -> ");
            cur = cur.next;
        }
        if (cur == null) {
            System.out.print("null");
        }
    }

    private static ListNode generate() {
        Random random = new Random();
        ListNode node = new ListNode(random.nextInt(10));
        ListNode cur = node;
        for (int i = 1; i < 5; i++) {
            cur.next = new ListNode(random.nextInt(10));
            cur = cur.next;
        }
        return node;
    }
}
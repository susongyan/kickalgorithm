
/**
 *  问题建模：
 *  整个问题转化为一个图论问题。
 *  从n到0，每个数字表示一个节点；
 *  如果两个数字 x 到 y 相差一个完全平方数，则连接一条边。
 *  得到一个无权图。
 *  那么原问题就转化为，求这个无权图从n到0的最短路径
 */
class Solution {
    public int numSquares(int n) {
        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair(n,0));
        boolean[] visited = new boolean[n+1]; // 用数组来做图节点已遍历的标示 O(1)的复杂度 比用Set O(n)的快很多
        visited[n] = true;
        while(!queue.isEmpty()){
            int num = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.poll();

            if(num == 0){
                return step;
            }

            for(int i = 1; ; i++){ 
                /* 
                * 这边要注意，不要重复已经计算过的点，因为这边要求的最短路径（不包含权重）
                * 所以下次再回到这个节点的话，步奏肯定比之前的大 
                */
                int a = num - i * i ;
                if(a < 0) 
                    break;
                if(a == 0)
                    return step + 1;
                if(!visited.[a]){
                    queue.offer(new Pair(a, step+1));
                    visited[a] = true;
                }
            }
        }
        return 0;
    }



    class Pair<TKey,TValue>{
        private TKey key;
        private TValue value;

        public TKey getKey() {
            return key;
        }

        public TValue getValue() {
            return value;
        }

        public Pair(TKey key, TValue value){
            this.key = key;
            this.value = value;
        }
    }
}

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
        Queue<Pair<Integer, Integer> queue = new LinkedList<>();
        queue.offer(new Pair(n,0));

        while(!queue.isEmpty()){
            int num = queue.peek().getKey();
            int step = queue.peek().getValue();
            queue.poll();

            if(num == 0){
                return step;
            }

            for(int i = 1; num - i * i >= 0; i++){
                queue.offer(new Pair(num - i*i, step+1));
            }
        }
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
/**
 * 
 * 先遍历数组，算出频率
 * 再用优先队列(最小堆 或者 最大堆)
 * Tn = 最大堆 - O(nlogn)  最小堆 - O(nlogk)
 */
class Solution {

    /**
     * 最大堆
     * 
     */
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o2.getValue() - o1.getValue());
        Map<Integer, Integer> frequence = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                frequence.put(nums[i], frequence.getOrDefault(nums[i],0)+1);
        }for (Map.Entry<Integer, Integer> pair : frequence.entrySet()) {
           queue.offer(pair);
        }

        while(!queue.isEmpty() && result.size() < k){
            result.add(queue.poll().getKey());
        }
        return result;
    }

    /**
     * 最小堆
     * 
     * Tn = O(nlogk)
     */
    public static List<Integer> topKFrequent2(int[] nums, int k) {
        List <Integer> result = new LinkedList<>();
        Queue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>((o1, o2) -> o1.getValue() - o2.getValue());
        Map<Integer, Integer> frequence = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
                frequence.put(nums[i], frequence.getOrDefault(nums[i],0)+1);
        }

        for (Map.Entry<Integer, Integer> pair : frequence.entrySet()) {
                // 由于这边使用的最小堆， 也就是说每次出队的是频率最小的元素；
                // 就可以保持优先队列的尺寸一直为k
                queue.offer(pair);
                if(queue.size() >k) {
                    queue.poll();
                }
        }

         /**
         * 由于这次优先队列是从频率小的poll到大的， 所以需要对输出做调整
         */
        while(!queue.isEmpty()){
            result.add(0,queue.poll().getKey());
        }
        return result;
    }
}
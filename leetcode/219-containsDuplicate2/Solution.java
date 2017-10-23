/**
 * 主要思路是： 查找表 + 滑动窗口
 * 通过查找表来减少查找次数，并利用滑动窗口来控制索引间隙
 * 
 * Tn = O(n);
 * Sn = O(k);
 */
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> slidingSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(slidingSet.contains(nums[i]))
                return true;
            slidingSet.add(nums[i]);
            if(slidingSet.size() == k + 1){ // 保持i++之后滑动窗口的长度为 k + 1
                slidingSet.remove(nums[i - k]); // 移除滑动窗口的第一个元素
            }
        }
        return false;
    } 

    public boolean containsNearbyDuplicate2(int[] nums, int k){
        Set<Integer> slidingSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
             /** 
              * 注意这边对滑动窗口的长度处理和上面一个的算法不一样，此处先计算了滑动窗口的宽度并且元素还未加入查找表中
              * 如果索引i个元素距离第一个元素（索引0）的距离大于k的话，就需要移除距离i的距离为k的前一个元素 i-k-1
              * 
              * 这里边界的比较思路： 
              * 1. 距离： k是求解距离，i是索引，第一个索引为0 所以 i-0 > k 即 i > k
              * 2. 查找表个数： 距离为k 则查找表需要保持的元素个数为 k+1 个， 
              *    索引i代表的元素个数为 i+1 所以 i+1 > k+1 结果也是 i > k
              */
            if(i > k) 
                slidingSet.remove(nums[i-k-1]);
            
            if(slidingSet.add(nums[i])) 
                return true;
        }
        return false;
    }
}
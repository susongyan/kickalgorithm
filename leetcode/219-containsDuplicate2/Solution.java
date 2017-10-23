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
}
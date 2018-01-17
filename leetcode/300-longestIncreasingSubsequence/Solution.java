package algrithm.longestincreasingsubsequence;

import java.util.Arrays;

/**
 * T(n) = O(n^2)
 */
public class Solution{
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        
        int[] cache = new int[nums.length];
        // 每个元素自身可以作为长度为1的子序列
        Arrays.fill(cache,1);
        
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                // 如果nums[i]比前面的大 则判断 cache[j]+1 是否比 cache[i]大
                if(nums[j] < nums[i]){
                    cache[i] = Math.max(cache[j] + 1, cache[i]);
                }
            }
        }

        int max = 1;
        for(int i = 0; i < cache.length; i++){
            max = Math.max(max, cache[i]);
        }
        return max;
    }

    /**
     * 状态： LIS(i) 表示[0...i]的范围内，选择数字nums[i] 可以获得的最长上升子序列
     * 状态转移方程：LIS(i) = max( 1 + LIS(j) if nums[i]>nums[j])
     */
}
package algrithm.partitionequalsubsetsum;

public class Solution{
    /**
     * 要判断数组是否能被分成两个和相等的部分，就相当于是否能找出和为 sum/2 的0-1背包问题
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
        }

        if(sum % 2 !=0 )
            return false;

        int n = nums.length;
        int c = sum/2;
        boolean[] cache = new boolean[c+1];
        
        for(int i = 0; i <= c; i++){
            cache[i] = (nums[0] == i);
        }

        for(int i = 1; i < n; i++){
            for(int j = c; j >= nums[i]; j--){
                cache[j] = cache[j] || cache[j-nums[i]];
            }
        }
        return cache[c];
    }

    /**
     * 使用 nums[0...index] 是否可以完全填充一个容量为sum的背包
     */
    private boolean tryPartition(int[] nums, int index, int sum){
        if(sum == 0)
            return true;
        
        if(sum < 0 || index < 0)
            return false;
        
            
        tryPartition(nums, index-1, sum) 
            || tryPartition(nums, index-1, sum - nums[index]);
    }
}
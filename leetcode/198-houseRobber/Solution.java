package algrithm.houserobber;

import java.util.Arrays;

public class Solution{
    int[] memory;
    public int rob(int[] nums) {
        // memory = new int[nums.length];
        // Arrays.fill(memory, -1);
        // return tryRobMemory(nums, 0);
        return tryRobDP(nums);
    }

    /**
     * 考虑抢劫 nums[index...nums.length),这个范围的所有房子
     */ 
    private int tryRobMemory(int[] nums, int index){
        if(index >= nums.length)
            return 0;
        if(memory[index] > -1)
            return memory[index];

        int result = 0;
        for(int i = index; i < nums.length; i++){
            result = Math.max(result, nums[i] + tryRobMemory(nums, i+2));
        }
        memory[index] = result;
        return result;
    }

    /**
     * 动态规划
     */
    private int tryRobDP(int[] nums){
        int n = nums.length;
        if(n == 0)
            return 0;

        // memo[i] 表示考虑抢劫 nums[i...n-1]所能获得的最收益
        int[] memo = new int[n];
        Arrays.fill(memo,-1);
        memo[n-1] = nums[n-1];
        for(int i = n-2; i >= 0; i--){
            for(int j = i; j < n; j++){
                memo[i] = Math.max(memo[i], nums[j] + (j+2<n ? memo[j+2]:0));
            }
        }
        return memo[0];
    }
}
package algrithm.climbingstaris;

public class Solution {
    int[] memory;

    public int climbStairs(int n) {
        memory = new int[n + 1];
        return calculateWays2(n);
    }

    // 递归
    public int calculateWays(int n) {
        // 当 n = 1 或 0 的时候，可能的走法就只有1种（n==2的话可以走两次1也可以走一次2）
        if (n == 0 || n == 1) {
            return 1;
        }
        // if(n==1){
     

        // if(n==2){
        //     return 2; 
        // }
        return calcula
          
     
    // 动态规划
    public int calculateWays2(int n){
        memory[0] = 1;
        memory[1] = 1;       
        for(int i = 2; i <= n; i++){
            memory[i] = memory[i-1] + memory[i-2];
        }
        return memory[n];
    }
}
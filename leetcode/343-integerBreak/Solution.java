package algrithm.integerbreak;

/**
 * 递归 -> 记忆化搜索 -> 动态规划
 */
public class Solution {
    //索引n对应的值表示: 数字n分割后的最大乘积
    private int[] memory;

    public int integerBreak(int n) {
        memory = new int[n + 1];
        // return breakIntegerMemory(n);
        return breakIntegerDynamicProgramming(n);
    }

    /**
     *  自顶向下 + 记忆化搜索， 避免递归中重叠子问题的大量重复计算
     */
    private int breakIntegerMemory(int n) {
        if (n == 1)
            return 1;

        if (memory[n] > 0) {
            return memory[n];
        }

        int result = -1;
        // 边界为 <= n-1, 因为最小要分割成2个数
        for (int i = 1; i <= n - 1; i++) {
            // i + (n-i) 或者 将 (n-i) 继续切分
            // 注意这里就存在大量的重复计算，也就是重叠子问题
            result = max3(result, i * (n - i), i * breakIntegerMemory(n - i));
        }
        memory[n] = result;
        return result;
    }

    /**
     * 自底向上， 动态规划
     * T(n) = n^2
     */
    private int breakIntegerDynamicProgramming(int n) {
        int[] memo = new int[n + 1];
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            // 计算 memo[i]
            for (int j = 1; j <= i - j; j++) {
                memo[i] = max3(memo[i], j * (i - j), j * memo[i - j]);
            }
        }
        return memo[n];
    }

    private int max3(int x, int y, int z) {
        return Math.max(Math.max(x, y), z);
    }
}
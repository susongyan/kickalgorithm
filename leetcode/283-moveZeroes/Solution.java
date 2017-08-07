public class Solution {

    public static void main(String[] args) {
        int[] nums = { 0, 1, 0, 3, 12 };
        Solution solution = new Solution();
        solution.print(nums);
        solution.moveZeroesViolently(nums);
        solution.print(nums);
    }

    /**
     * 双游标： nextNonZeroIndex记录下一个非零索引，遍历数组将非零元素放置nextNonZeroIndex位置并往前移动
     * Tn = O(n)
     * Sn = O(1)
     */
    public void moveZeroes(int[] nums) {
        int nextNonZeroIndex = 0; // 非零占位
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nextNonZeroIndex++] = nums[i];
            }
        }
        // 剩余元素就都是0了
        for (int remaining = nextNonZeroIndex; remaining < nums.length; remaining++) {
            nums[remaining] = 0;
        }
    }

    /**
     * 暴力解法:  循环两次，将为0的的数依次传递（冒泡）到末尾
     * Tn = O(n^2)
     * Sn = O(1)
     */
    public void moveZeroesViolently(int[] nums) {
        int temp = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == 0 && nums[j] != 0) {
                    temp = nums[j];
                    nums[j] = nums[i];
                    nums[i] = temp;
                    break;
                }
            }
        }
    }

    private void print(int[] nums) {
        for (int item : nums) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
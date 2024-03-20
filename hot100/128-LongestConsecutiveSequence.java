
/**
 * 128. 最长连续序列
 * 
 
 
给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。

请你设计并实现时间复杂度为 O(n) 的算法解决此问题。


示例 1：

输入：nums = [100,4,200,1,3,2]
输出：4
解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。
示例 2：

输入：nums = [0,3,7,2,5,8,4,6,0,1]
输出：9
 

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109


// 思路： 强调时间复杂度 O(n), 那就不能排序了， 时间被限定后 就转移到空间上找办法，可以用hash表做什么？ 
   hash表  key可以快速查找，排序的特征是 +-1 

   https://www.youtube.com/watch?v=rc2QdQ7U78I

 */
class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
       
        int max = 0;
        for (int num : nums) {
            boolean lowerBound = !set.contains(num-1); //如果num-1 不存在里边，则表明是连续中最小的
            if (lowerBound) {
                int length = 1;
                while(set.contains(++num)) {
                    length++;
                }
                if (length > max) {
                    max = length;
                }
            }
        } 
        return max;
    }
}
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 

给你一个整数数组 nums ，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k ，同时还满足 nums[i] + nums[j] + nums[k] == 0 。请

你返回所有和为 0 且不重复的三元组。

注意：答案中不可以包含重复的三元组。

 

 

示例 1：

输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]
解释：
nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0 。
nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0 。
nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0 。
不同的三元组是 [-1,0,1] 和 [-1,-1,2] 。
注意，输出的顺序和三元组的顺序并不重要。
示例 2：

输入：nums = [0,1,1]
输出：[]
解释：唯一可能的三元组和不为 0 。
示例 3：

输入：nums = [0,0,0]
输出：[[0,0,0]]
解释：唯一可能的三元组和为 0 。
 

提示：

3 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
class Solution {

    /**
        特征：要加起来为0， 肯定是有负数， 几个数肯定要分布在数值 0 的两侧， 那么先排序后，就可以用两头的指针 根据大小来看向哪边挪动
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // nlogn
        List<List<Integer>> res = new ArrayList<>();
        for (int k = 0; k < nums.length - 2; k++) {
            // nums[k] 肯定要是负数， 三个加起来才可能是0
            if (nums[k] > 0) 
                break;
            
            if (k > 0 && nums[k] == nums[k-1]) continue; //重复项过滤
            
            int i = k + 1;
            int j = nums.length - 1;
            
            while (i < j) {
                int sum = nums[k] + nums[i] + nums[j];
                if (sum == 0) {
                    res.add(new ArrayList<Integer>(Arrays.asList(nums[k], nums[i], nums[j])));
                     while (i < j && nums[i] == nums[++i]); //重复项过滤
                     while (i < j && nums[j] == nums[--j]); //重复项过滤
                } else if (sum < 0) { // 小于0，要继续找大于0的数， 移动i
                   while (i < j && nums[i] == nums[++i]); // 因为 sum < 0, 所以要找从较小的i 开始找大一点的元素
                } else {
                   while (i < j && nums[j] == nums[--j]); // 因为 sum > 0, 所以要找从要找小一点的元素 从右向左找  
                }
            }
        }
        return res;
    }
}
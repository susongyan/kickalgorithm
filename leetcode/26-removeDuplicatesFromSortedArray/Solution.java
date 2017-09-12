
/**
 * 注意点: 数组已排序, 只有一个元素的时候 长度为1
 * 边界: 
 *     [1]   -> 1 [1]
 *     [1,1] -> 1 [1]
 *     [1,2] -> 2 [1,2]
 * 
 * 思路： 利用快慢指针， 将慢指针slow位置作为判重标准; 最终排重元素长度为 slow + 1 
 * 复杂度： Tn = O(n); Sn = O(1);
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int  slow = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[low] != nums[i]){
                nums[++slow] = nums[i];  // 注意 这里是 ++len , 和28不一样 此处去冲的慢指针是基准
            }
        }
        return slow + 1;
    }
}
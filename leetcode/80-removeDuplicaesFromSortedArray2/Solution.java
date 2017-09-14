/**
 * 

Follow up for "26-Remove Duplicates":
What if duplicates are allowed at most twice? 最多可以重复两次

For example,
Given sorted array nums = [1,1,1,2,2,3],
Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3.
It doesn't matter what you leave beyond the new length.
 * 
 * 
 * 
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;
        if(nums.length == 1)
            return 1;
        
        int duplicateCount = 1;
        int index = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[index] == nums[i]){
                if(duplicateCount < 2){ // 在26的基础上增加一层重复次数的判断
                    nums[++index] = nums[i];
                    duplicateCount++;
                }
            }else{
                nums[++index] = nums[i];
                duplicateCount = 1;
            }
        }
        return index + 1;
    }
}
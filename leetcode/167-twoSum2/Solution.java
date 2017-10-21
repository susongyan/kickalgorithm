
/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 *  The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 *  You may assume that each input would have exactly one solution and you may not use the same element twice.

Input: numbers={2, 7, 11, 15}, target=9
Output: index1=1, index2=2
 */
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        /* 由于数组为已排序， 由数组两端索引开始，如果相加大于target则向左移动high，
         * 如果小于target则向右移动low索引；直到两个索引相遇
         */
        int[] found = new int[2];
        int low = 0;
        int high = numbers.length - 1;
        
        int sum = 0;
        while(low < high && (sum = numbers[low] + numbers[high]) != target){
            if(sum > target)
                high--;
            else 
                low++;
        }
        if(low < high){//found 
            found[0] = low + 1; // 注意 本题要求返回的是第几个 而不是0开始的索引
            found[1] = high + 1;
        } 
        return found;
    }
}
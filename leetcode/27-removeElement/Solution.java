import java.util.Arrays;


class Solution{

    public static void main(String[] args){
        int[] nums = [3,2,2,3];
        int removed = 3;
        
        int length = new Solution().removeElement(nums, removed);

         System.out.println("after removed, length is : " + length);
         System.out.println("after removed, nums: " + Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val){
        int len = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != val)
            nums[len++] = nums[i];
        }
        return len;
    }
}
import java.util.Map;

/**
 * 如果用暴力的双重for循环，查找每个元素的另一个目标元素都要遍历n次；
 * 如果引入map这种数据结构容器作为查找表 利用它只需要O(1)的查找效率 总共只需2n次查找（塞入map + 在map中查找目标元素）
 * Tn = O(n)
 * Sn = O(n)
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> searchMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
             searchMap.put(nums[i], i);
        }

        for(int i = 0; i < nums.length; i++){
            if(searchMap.containsKey(target - nums[i]) && searchMap.get(target - nums[i]) != i){
                return new int[]{i,searchMap.get(target - nums[i])};
            }
        }
        return new int[2];
    }

    /**
     * 改进
     * 上面的需要先把所有的元素塞入到查找表中， 再遍历寻找
     * 考虑： 装入查找表的时候一边查找目标元素 这样就把上述的2n的复杂度减少为n
     * 
     */
    public int[] twoSum2(int[] nums, int target){
        int[] result = new int[2];
        Map<Integer,Integer> searchMap = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length; i++){
            if(searchMap.containsKey(target - nums[i])){
                result[1] = i;
                result[0] = searchMap.get(target - nums[i]);
                return result;
            }
            searchMap.put(nums[i], i); 
        }
        return result;
    }
}
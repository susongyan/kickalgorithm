
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> intersectList = new ArrayList<Integer>();
        Map<Integer, Integer> map = new HashMap<>(); // {element, 出现次数}
        for(int i = 0; i < nums1.length; i++){
            if(!map.containsKey(nums1[i])){
                map.put(nums1[i],1);
            }else{
                map.put(nums1[i], map.get(nums1[i])+1);
            }
        }

        for(int i = 0; i < nums2.length; i++){
            // 如果第二个数组元素在map中存在则将该元素推入结果集中 并 将出现次数减一
            if(map.containsKey(nums2[i]) && map.get(nums2[i])> 0){
                intersectList.add(nums2[i]);
                map.put(nums2[i], map.get(nums2[i])-1);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for(int e : intersectList){
            result[i++] = e;
        }
        return result;
    }
}
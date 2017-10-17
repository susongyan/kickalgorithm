import java.util.*;

/**
 *  利用Set元素不重复的特性，先将一个数组的元素存入， 再依次比对另一个数组中是否有相同元素
 *  Tn = O(n)
 */
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {        
        Set resultSet = new HashSet<Integer>();
        Set set = new HashSet<Integer>();
        for (int i : nums1) {
            set.add(i);
        }
        for (int i : nums2) {
            if (set.contains(i)) {
                resultSet.add(i);
            }
        }

        int[] result = new int[resultSet.size()];
        Iterator iterator = resultSet.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            result[i++] = (int) iterator.next();
        }
        return result;
    }
}
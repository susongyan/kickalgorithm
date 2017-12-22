package algrithm.permutations;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    private List<List<Integer>> result;
    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<List<Integer>>();
        List<Integer> permutation = new ArrayList<>();
        used = new boolean[nums.length];
        findPermutation(nums, 0, permutation);
        return result;
    }

    private void findPermutation(final int[] nums, int index, List<Integer> permutation) {

        if (index == nums.length) {
            result.add(new ArrayList(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int chose = nums[i];
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation.add(chose);
            findPermutation(nums, index + 1, permutation);
            // 注意， 回溯的时候重置状态
            used[i] = false; 
            permutation.remove(index);
        }
    }
}
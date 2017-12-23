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
       // findPermutation(nums, 0, permutation);
        findPermutationDebugInfo(nums, 0, permutation);
        return result;
    }

    /**
     *  Perms(nums[0...n-1]) = {取出一个数字} + Perms(nums[{0...n-1}- 这数字])
     */
    private void findPermutation(final int[] nums, int index, List<Integer> permutation) {

        if (index == nums.length) {
            result.add(new ArrayList(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation.add(nums[i]);
            findPermutation(nums, index + 1, permutation);
            // 注意， 回溯的时候重置状态
            used[i] = false; 
            permutation.remove(index);
        }
    }

    private void findPermutationDebugInfo(final int[] nums, int index, List<Integer> permutation) {

        if (index == nums.length) {
            result.add(new ArrayList(permutation));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            used[i] = true;
            permutation.add(nums[i]);
            System.out.println("choose: i=" + i +", element="+nums[i] + ", index=" + index);
            System.out.println("used:");
            print(used);
            System.out.println("permutation:");
            print(permutation);
            findPermutationDebugInfo(nums, index + 1, permutation);
            // 注意， 回溯的时候重置状态
            used[i] = false; 
            permutation.remove(index);
            System.out.println("===============recalling: i="+i + ", index="+index);
            System.out.println("used:");
            print(used);
            System.out.println("permutation:");
            print(permutation);
        }
    }

    private void print(boolean[] boolArray){
        for(int i = 0; i < boolArray.length; i++){
           System.out.print(boolArray[i] + ","); 
        }
        System.out.println();
    }

    private <T> void print(List<T> list){
        for(T item : list){
            System.out.print(item.toString() + ",");
        }
        System.out.println();
    }
}
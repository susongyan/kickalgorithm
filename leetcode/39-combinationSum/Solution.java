package algrithm.combinationsum;

import java.util.List;
import java.util.ArrayList;

public class Solution{
    List<List<Integer>>  result;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<List<Integer>>();
        List<Integer> combine = new ArrayList<>();
        findCombinationSum(candidates, target, 0, combine);
        return result; 
    }

    private void findCombinationSum(int[] candidates, int remaining, int start, List<Integer> combine){
        if(remaining == 0){
            result.add(new ArrayList(combine));
            return;
        }else if(remaining < 0){
            return;
        }

        for(int i = start; i < candidates.length; i++){
            combine.add(candidates[i]);
            // 注意这边递归的时候还是i， 因为元素可以复用
            findCombinationSum(candidates, remaining - candidates[i], i, combine);
            // backtrack 回溯
            combine.remove(combine.size() - 1);
        }
    }
}
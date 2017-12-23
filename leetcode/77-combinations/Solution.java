package algrithm.combinations;

import java.util.List;
import java.util.ArrayList;

public class Solution{
    private List<List<Integer>> result;

    public List<List<Integer>> combine(int n, int k){
        result = new ArrayList<List<Integer>>();
        if(n <= 0 || k <= 0 || k > n)
            return result;

        List<Integer> combine = new ArrayList<>();
        findCombination(n, k, 1, combine);
        return result;
    }

    // 求解C(n,k) 当前已经找到的组合存储在combine中， 需要从start开始搜索新的元素；
    // 由于每组组合是没有顺序的，所以不需要再搜索start之前的元素，因为start之前元素的所有组合已经搜索完毕
    private void findCombination(int n, int k, int start, List<Integer> combine){
        if(combine.size() == k){
            result.add(new ArrayList(combine));
            return;
        }
        
        for(int i = start; i <= n; i++){
            combine.add(i);
            findCombination(n,k, i+1 ,combine);
            combine.remove(combine.size() - 1); // 移除刚加进去的元素
        }
    }
}
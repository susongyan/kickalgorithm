package algrithm.asigncookies;

import java.util.Arrays;
public class Solution{

    /**
     * 贪心算法
     * 
     * 先满足最贪心的那个小朋友，把最大的饼干分给他， 如果满足结果+1 否则放弃
     * 
     * 也可以反过来 先满足最不贪心的小朋友
     * 
     * T(n) = O(nlogn)
     */
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int si = s.length - 1;
        int gi = g.length - 1;
        int result = 0;
        while(gi >= 0 && si >= 0){
            if(s[si] >= g[gi]){
                result ++;
                si--;
                gi--;
            }else{
                gi--;
            }
        }
        return result;
    }
}
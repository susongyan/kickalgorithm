package ssy.pri.algrithm;

class Solution{
    /**
     * 由于题目限制了每个数组的长度500，借鉴 2Sum 的思路， 
     * 将两个数组为一组把和放入查找表中作为key，相同和的个数作为value
     * 
     * Tn = O(n^2)
     * Sn = O(n^2)
     */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        int result = 0;
        for(int i = 0; i < A.length; i++)
            for(int j = 0; j < B.length; j++){
                int sum = A[i] + B[j];
                if(!map.containsKey(sum))
                    map.put(sum,1);
                else
                    map.put(sum, map.get(sum) + 1);
            }
        
         for(int i = 0; i < C.length; i++)
            for(int j = 0; j < D.length; j++){
                int sum = C[i] + D[j];
                if(map.containsKey(0 - sum)){
                    result += map.get(0 - sum);  // 这边不减小map中的个数，因为这个可以复用   
                }
            }
         
        return result;
    }
}
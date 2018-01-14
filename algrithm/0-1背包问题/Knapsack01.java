package algrithm;

 /**
  * 0-1背包问题
  */
 public class Knapsack01{

    public void main(String[] args){

    }
    
    /**
     * T(n,c) = n*c
     * S(n,c) = n*c
     * @param weights 重量
     * @param prices  价值
     * @param c 剩余容量
     */
    public int knapsack01(int[] weights, int[] prices, int c){
        int n = weights.length;
        if(n == 0)
           return 0;
        int[][] cache = new int[n][c+1];
        for(int j = 0; j <= c; j++){
            // 将第一个元素放入容量为j的背包里，最大价值
            cache[0][j] = (j >= weights[0] ? prices[0]:0 );
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= c; j++){
                // 第i个不放入背包 不占用容量 0
                cache[i][j] = cache[i-1][j];
                // 第i个放入背包 1
                if(j>= w[i]){
                    cache[i][j] = Math.max(cache[i][j], v[i] + cache[i-1][j-w[i]]);
                }
            }
        }
        return cache[n-1][c];
    }
 }
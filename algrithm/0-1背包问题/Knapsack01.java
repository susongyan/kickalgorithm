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
                if(j>= weights[i]){
                    cache[i][j] = Math.max(cache[i][j], prices[i] + cache[i-1][j-weights[i]]);
                }
            }
        }
        return cache[n-1][c];
    }

    /**
     * 由于第i行的解只与上一行的有关系，可以优化空间复杂度，只保留两行
     * 
     * S(c,n) = O(2n) = O(n)
     */
    public int knapsack01_Optimize(int[] weights, int[] prices, int c){
        int n = weights.length;
        if(n == 0)
           return 0;
        int[][] cache = new int[2][c+1]; // 只保留两行
        for(int j = 0; j <= c; j++){
            // 将第一个元素放入容量为j的背包里，最大价值
            cache[0][j] = (j >= weights[0] ? prices[0]:0 );
        }
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j <= c; j++){
                int currCacheRow = i%2;
                int prevCacheRow = (i-1)%2;
                // 第i个不放入背包 不占用容量 0
                cache[currCacheRow][j] = cache[prevCacheRow][j];
                // 第i个放入背包 1
                if(j>= weights[i]){
                    cache[currCacheRow][j] = Math.max(cache[currCacheRow][j], prices[i] + cache[prevCacheRow][j-weights[i]]);
                }
            }
        }
        return cache[(n-1)%2][c];
    }

    /**
     *  进一步优化，只需要一维数组
     * 
     * 
     */
    public int knapsack01_Optimize2(int[] weights, int[] prices, int c){
        int n = weights.length;
        if(n == 0)
           return 0;
        int[][] cache = new int[c+1];
        for(int j = 0; j <= c; j++){
            cache[j] = (j >= weights[0] ? prices[0]:0 );
        }
        
        for(int i = 1; i < n; i++){
            for(int j = c; j >= prices[i]; j++){
                    cache[j]= Math.max(cache[j], prices[i] + cache[j-weights[i]]);
                }
            }
        }
        return cache[n-1][c];
    }
 }
package algrithm.numberofislands;

public class Solution{
    private int result = 0;
    private boolean[][] marked;
    private int rows, columns;
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0)
            return result;
        rows = grid.length;
        columns = grid[0].length;
        marked = new boolean[rows][columns];

        // 遍历寻找新的还未归属其他岛屿的陆地，然后标记所有属于当前岛屿的陆地
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                if(grid[i][j] != '0' && marked[i][j] == false){
                    result++;
                    markIsland(grid, i, j);
                }
            }
        }
        return result;
    }

    /**
     * 回溯标记当前岛屿的所有陆地
     */
    public void markIsland(char[][] grid, int i, int j){
        if(i > rows - 1 || i < 0 || j > columns - 1 || j < 0
            || grid[i][j]  == '0' 
            || marked[i][j]){
                return;
            }
        
        marked[i][j] = true;
        markIsland(grid, i, j + 1);
        markIsland(grid, i, j - 1);
        markIsland(grid, i + 1, j);
        markIsland(grid, i - 1, j);
    }
}
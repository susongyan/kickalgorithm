package algrithm.nqueens;

import java.util.List;
import java.util.ArrayList;

/**
 * n 皇后问题难点在于如何判断第index行不能放置的位置
 * 然后回溯寻找所有的解
 */
public class Solution{
    private List<List<String>> result;

    // 标记第几列已经占用
    private boolean[] columns;

    /** 一个方向的对角线个数为 2n - 1
    * 左下到右上的对角线，同一条对角线上的 x+y 值相等
    * 右下到左上的对角线，同一条对角线上的 x-y 值相等，因为存在负数可以弄成 x - y + n - 1
    */
    private boolean[] diagonal1;
    private boolean[] diagonal2;

    public List<List<String>> solveNQueens(int n) {
        columns = new boolean[n];
        diagonal1 = new boolean[2 * n-1];
        diagonal2 = new boolean[2 * n-1];

        result = new ArrayList<List<String>>();
        List<Integer> row = new ArrayList<>(n);
        putQueen(n, 0, row);
        return result;
    }

    /**
     * @param n 问题规模
     * @param index 第几行
     * @param row 每一行皇后摆放的位置
     */
    private void putQueen(int n, int index, List<Integer> row){
        if(index == n){
            result.add(generateBoard(row));
            return;
        }
        
        for(int i = 0; i < n; i++){
            int dialIndex1 = index + i;
            int dialIndex2 = index - i + n - 1;
            if(columns[i] || diagonal1[dialIndex1] || diagonal2[dialIndex2]){
                continue;
            }
            columns[i] = true;
            diagonal1[dialIndex1] = true;
            diagonal2[dialIndex2] = true;
            row.add(i);
            putQueen(n, index + 1, row);
            // backtracking
            columns[i] = false;
            diagonal1[dialIndex1] = false;
            diagonal2[dialIndex2] = false;
            row.remove(row.size() - 1); 
        }
    }

    private List<String> generateBoard(List<Integer> row){
        List<String> result = new ArrayList<String>();
        for(int i = 0; i < row.size(); i++){
            String s = "";
            for(int j = 0; j < row.size(); j++){
                s += (row.get(i) == j ? 'Q' : '.');
            }
            result.add(s);
        }
        return result;
    }
}
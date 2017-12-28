package algrithm.wordsearch;

public class Solution {
    private boolean[][] scanned;
    private int[][] move = new int[][] { { 0, -1 }, { 1, 0 }, { 0, 1 }, { -1, 0 } };

    public boolean exist(char[][] board, String word) {
        if (board.length <= 0) {
            return false;
        }
        scanned = new boolean[board.length][board[0].length];
        // 这边的二重for循环是为了找到匹配目标单词第一个字符的位置，接着再回溯寻找相邻元素
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(searchWord(board, word, 0, i, j)){
                    return true;
                }
            }
        }
        return false;
    }

    // index为word的索引
    public boolean searchWord(char[][] board, String word, int index, int x, int y) {
        if (index == word.length()) {
            return true;
        }

        // 注意 board[x][y] x和y分别指的是 二维数组的Y轴和X轴方向的索引
        if (x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1
         || board[x][y] != word.charAt(index) 
         || scanned[x][y]) {
            return false;
        }

        boolean result = false; 
        for(int i = 0; i < 4; i ++){
            scanned[x][y] = true; 
            result = result || searchWord(board, word, index + 1, x + move[i][0],y + move[i][1]);
            scanned[x][y] = false;
        }
        return result;
    }
}
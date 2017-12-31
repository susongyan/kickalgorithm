[51. N-Queens](https://leetcode.com/problems/n-queens/description/)

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.

n皇后问题是指将n个皇后放置在 n * n 的棋盘格上，两两皇后之间不会互相进攻到对方。

![](https://leetcode.com/static/images/problemset/8-queens.png)
Given an integer n, return all distinct solutions to the n-queens puzzle.

给定一个整数 n ， 返回 n皇后问题的解，解不能重复。

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

每个解包含一个独特的 n 皇后摆放的平面设置， 其中 'Q' 代表皇后，'.' 代表空格

For example,
There exist two distinct solutions to the 4-queens puzzle:

比如说 4皇后问题存在2个不同的解：

```
[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]
```
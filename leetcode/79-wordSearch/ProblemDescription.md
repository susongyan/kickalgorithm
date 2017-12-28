[79. Word Search](https://leetcode.com/problems/word-search/description/)

Given a 2D board and a word, find if the word exists in the grid.

给定一个二维平面和一个单词，检查单词是否存在于格子中。

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

单词可由相邻单元格的字符组成，这边的“相邻”单元格指的是水平或垂直毗邻的格子。同一个字符只能用一次。

For example,
Given board =
```
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
```

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
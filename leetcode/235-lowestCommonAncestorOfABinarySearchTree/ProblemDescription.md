[235. Lowest Common Ancestor of a Binary Search Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/)
235 

Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

给定一个二叉搜索树（BST），找出指定两个节点的最小公共祖先(LCA)。

According to [the definition of LCA on Wikipedia](https://en.wikipedia.org/wiki/Lowest_common_ancestor): “The lowest common ancestor is defined between two nodes v and w as the lowest node in T that has both v and w as descendants (where we allow a node to be a descendant of itself).”

根据维基百科对 LCA 的定义，“在二叉搜索树中，最小公共祖先节点指在两个节点 v 和 w 之间最低的并且两个节点都是其子孙节点的的那个节点（节点可以认为是自己的子孙节点）”

```
   _______6______
       /              \
    ___2__          ___8__
   /      \        /      \
   0      _4       7       9
         /  \
         3   5
```

For example, the lowest common ancestor (LCA) of nodes 2 and 8 is 6. Another example is LCA of nodes 2 and 4 is 2, since a node can be a descendant of itself according to the LCA definition.

比如说，2 和 8 的最小公共祖先是 6。再如， 2 和 4 的最小公共祖先是 2， 因为 LCA 的定义中节点本身可以认为是自己的子孙节点。
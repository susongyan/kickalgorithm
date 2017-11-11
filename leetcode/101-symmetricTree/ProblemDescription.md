[101. Symmetric Tree](https://leetcode.com/problems/symmetric-tree/description/)

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

给定一个二叉树，判断它是不是自身的镜像（也就是中心对称）

For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

比如说，下面这个二叉树 [1,2,2,3,4,4,3] 是对称的

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following [1,2,2,null,3,null,3] is not:

但是下面这个 [1,2,2,null,3,null,3] 就不是对称的：

```
    1
   / \
  2   2
   \   \
   3    3
```
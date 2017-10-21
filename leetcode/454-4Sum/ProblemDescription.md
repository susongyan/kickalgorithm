[4Sum](https://leetcode.com/problems/4sum-ii/description/)

Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.

给定4个整型数组A，B，C，D， 计算有多少个组合 （i,j,k,l)使得 A[i] + B[j] + C[k] + D[l] 等于0

To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -2^28 to 2^28 - 1 and the result is guaranteed to be at most 2^31 - 1.
为了问题稍微简单点，这几个数组长度一致都为N， 0 <= N <= 500。 所有整数的值都在 -2^28 到 2^28 - 1 范围内， 并且结果最多有 2^31-1 个

Example:

    Input:
    A = [ 1, 2]
    B = [-2,-1]
    C = [-1, 2]
    D = [ 0, 2]

    Output:
    2

    Explanation:
    The two tuples are:
    1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
    2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
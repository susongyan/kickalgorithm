
/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

    Note: You may not slant the container and n is at least 2.

    思路： 盛水量 = 索引差值 * 两个点y轴较小的高度
        也就是说，两个点x轴距离越远，高度低值越高 盛水量就越大
        点的高度一开始不能知道，但是我们可以确定数组开头和结尾两个点的x轴距离为宽度最大的两个点

    Tn = O(n);
    Sn = O(1);
 */
class Solution {
    public int maxArea(int[] height) {
       if (height == null || height.length == 0)
            return 0;

         int area = 0;
         int low  = 0;
         int high = height.length - 1;

         while(low < high){
             area = Math.max(area, (high - low) * Math.min(height[low],height[high]));
             
             // 由于宽度不断缩小， 而且水容量取决于高度较低的点，
             // 移动更高的点 水位高度仍旧由高度低的那个点决定，而宽度在缩小 水容量只会更小 
             if(height[low] < height[high])
                 low++;
             else
                 high--;
         }
         return area;
    }
}
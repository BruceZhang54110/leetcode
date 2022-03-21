package com.zhw.leetcode.home.top100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 *
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 返回容器可以储存的最大水量。
 *
 * 说明：你不能倾斜容器。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  <h1>双指针
 * 复杂度分析
 *
 * 时间复杂度：O(N)O(N)，双指针总计最多遍历整个数组一次。
 *
 * 空间复杂度：O(1)O(1)，只需要额外的常数级别的空间。
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] arr = {1,8,6,2,5,4,8,3,7};
        System.out.println(getMaxArea(arr));
    }

    public static int getMaxArea(int[] height) {
        int maxArea = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            maxArea = Math.max(maxArea, (Math.min(height[i], height[j])) * (j- i));
            if (i < j) {
                i++;
            } else {
                j--;
            }
        }
        return maxArea;
    }
}

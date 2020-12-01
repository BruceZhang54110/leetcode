package com.zhw.leetcode.easy.array;

import java.util.Arrays;

/**
 * 给定一个按非递减顺序排序的整数数组 A，返回每个数字的平方组成的新数组，要求也按非递减顺序排序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * 示例 2：
 *
 * 输入：[-7,-3,2,3,11]
 * 输出：[4,9,9,49,121]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A 已按非递减顺序排序。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/squares-of-a-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        int[] A = new int[] {-4,-1,2,3,5,10};
        int[] result = sortedSquares2(A);
        for (int i : result) {
            System.out.print(i + " ,");
        }
    }

    /**
     * 1. 因为是按非递减顺序排序，所以先找到最大的一个负数
     * 2. i = 最大的负数的下标,  j = i + 1 , 比较 A[i] * A[i] 和A[j] * A[j]的大小，将较小的放入结果数组
     * 3. 如果将负数比较完了，就依次将正数的乘积放入
     * @param A
     * @return
     */
    public static int[] sortedSquares1(int[] A) {
        int n = A.length;
        int negative = -1;
        for (int i = 0; i < n; i++) {
            if (A[i] < 0) {
                negative = i;
            } else {
                break;
            }
        }

        int[] ans = new int[n];
        int i = negative;
        int j = negative + 1;
        int index = 0;
        while (i >= 0 || j < n) {
            if (i < 0) {
                ans[index] = A[j] * A[j];
                ++j;
            } else if (A[i] * A[i] < A[j] * A[j]) {
                ans[index] = A[i] * A[i];
                --i;
            } else {
                ans[index] = A[j] * A[j];
                ++j;
            }
            ++index;
        }
        return ans;

    }

    public static int[] sortedSquares2(int[] A) {
        int n = A.length;
        int[] ans = new int[n];
        for (int i = 0, j = n - 1, pos = n - 1; i <= j;) {
            if (A[i] * A[i] > A[j] * A[j]) {
                ans[pos] = A[i] * A[i];
                ++i;
            } else {
                ans[pos] = A[j] * A[j];
                --j;
            }
            --pos;
        }
        return ans;

    }


}

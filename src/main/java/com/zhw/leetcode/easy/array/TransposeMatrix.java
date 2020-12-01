package com.zhw.leetcode.easy.array;

/**
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 *
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 * 示例 2：
 *
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 *  
 *
 * 提示：
 *
 * 1 <= A.length <= 1000
 * 1 <= A[0].length <= 1000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/transpose-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *  int [][] a = new int[2][3]; // 2行 3列 第一个是行数 第二个是列数
 *         a[0][0] = 1;
 *         a[0][1] = 2;
 *         a[0][2] = 3;
 *
 *         a[1][0] = 4;
 *         a[1][1] = 5;
 *         a[1][2] = 6;
 *         System.out.println(a.length);
 *         System.out.println(a[0].length);
 */
public class TransposeMatrix {
    public static void main(String[] args) {

    }

}

class Solution {
    public int[][] transpose(int[][] A) {
       int m = A.length; // 行数
       int n = A[0].length; // 列数
       int [][] result = new int[n][m];
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               result[j][i] = A[i][j];
           }

       }
       return result;
    }
}

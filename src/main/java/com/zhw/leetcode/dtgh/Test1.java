package com.zhw.leetcode.dtgh;

/**
 * 复杂度分析
 *
 * 时间复杂度：O(n^2)O(n
 * 2
 *  )，其中 nn 为数组 \textit{nums}nums 的长度。动态规划的状态数为 nn，计算状态 dp[i]dp[i] 时，需要 O(n)O(n) 的时间遍历 dp[0 \ldots i-1]dp[0…i−1] 的所有状态，所以总时间复杂度为 O(n^2)O(n
 * 2
 *  )。
 *
 * 空间复杂度：O(n)O(n)，需要额外使用长度为 nn 的 dpdp 数组
 *
 * 作者：LeetCode-Solution
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence/solution/zui-chang-shang-sheng-zi-xu-lie-by-leetcode-soluti/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * 最长递增子序列
 */
public class Test1 {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 5, 2, 4, 3};
        System.out.println("result:" + getMaxLength(arr));
    }

    public static int getMaxLength(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
             }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}

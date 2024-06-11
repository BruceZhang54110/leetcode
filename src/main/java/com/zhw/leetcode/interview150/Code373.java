package com.zhw.leetcode.interview150;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
/**
 * 373. 查找和最小的 K 对数字
 * 已解答
 * 中等
 * 相关标签
 * 相关企业
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 *
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 *
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 * 示例 1:
 *
 * 输入: nums1 = [1,7,11], nums2 = [2,4,6], k = 3
 * 输出: [1,2],[1,4],[1,6]
 * 解释: 返回序列中的前 3 对数：
 *      [1,2],[1,4],[1,6],[7,2],[7,4],[11,2],[7,6],[11,4],[11,6]
 */
public class Code373 {
    public static void main(String[] args) {
        List<List<Integer>> lists = kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3);
        System.out.println(lists);

    }

    public static List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        List ans = new ArrayList<List<Integer>>(k); // 预分配空间
        // 构造优先队列，指定升序排序方式（小根堆）
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        for (int i = 0; i < Math.min(n, k); i++) { // 至多k个
            pq.add(new int[]{nums1[i] + nums2[0], i, 0}); // (0,0 1,0 2,0 ... k,0)
        }
        while (!pq.isEmpty() && ans.size() < k) {
            int[] p = pq.poll(); // 出堆，堆中最小的
            int i = p[1];
            int j = p[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < m) {
                pq.add(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }

        }
        return ans;
    }
}

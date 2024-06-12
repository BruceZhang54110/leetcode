package com.zhw.leetcode.interview150;

import java.util.Arrays;

/**
 * 169. 多数元素
 * 已解答
 * 简单
 * 相关标签
 * 相关企业
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 *
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * 示例 1：
 *
 * 输入：nums = [3,2,3]
 * 输出：3
 * 示例 2：
 *
 * 输入：nums = [2,2,1,1,1,2,2]
 * 输出：2
 * 方法二：排序
 * 思路
 *
 * 如果将数组 nums 中的所有元素按照单调递增或单调递减的顺序排序，那么下标为 ⌊n2⌋\lfloor \dfrac{n}{2} \rfloor⌊
 * 2
 * n
 * ​
 *  ⌋ 的元素（下标从 0 开始）一定是众数。
 *
 * 算法
 *
 * 对于这种算法，我们先将 nums 数组排序，然后返回上文所说的下标对应的元素。下面的图中解释了为什么这种策略是有效的。在下图中，第一个例子是 nnn 为奇数的情况，第二个例子是 nnn 为偶数的情况。
 *
 * 对于每种情况，数组上面的线表示如果众数是数组中的最小值时覆盖的下标，数组下面的线表示如果众数是数组中的最大值时覆盖的下标。对于其他的情况，这条线会在这两种极端情况的中间。
 * 对于这两种极端情况，它们会在下标为 ⌊n2⌋\lfloor \dfrac{n}{2} \rfloor⌊
 * 2
 * 复杂度分析
 *
 * 时间复杂度：O(nlog⁡n)O(n\log n)O(nlogn)。将数组排序的时间复杂度为 O(nlog⁡n)O(n\log n)O(nlogn)。
 *
 * 空间复杂度：O(log⁡n)O(\log n)O(logn)。如果使用语言自带的排序算法，需要使用 O(log⁡n)O(\log n)O(logn) 的栈空间。如果自己编写堆排序，则只需要使用 O(1)O(1)O(1) 的额外空间。
 *
 * 作者：力扣官方题解
 * 链接：https://leetcode.cn/problems/majority-element/solutions/146074/duo-shu-yuan-su-by-leetcode-solution/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class Code169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }

    public static int majorityElement(int[] nums) {

        Arrays.sort(nums);
        return nums[nums.length / 2];

    }
}

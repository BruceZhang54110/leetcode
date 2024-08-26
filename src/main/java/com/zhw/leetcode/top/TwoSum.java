package com.zhw.leetcode.top;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 *
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 *
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 *  
 *
 * 提示：
 *
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 10, 5};
        System.out.println(Arrays.toString(twoNumTest(nums, 5)));
    }

    /**
     * 两数之和
     * @param nums
     * @param target
     * @return
     */
    public static  int[] twoSum(int[] nums, int target) {
        // 根据题目中描述，数组中同一个元素在答案里不能重复出现，利用键值对存放数组值和下标。key为元素，value为元素所在下标
        // 遍历数组，如果存在key = target - nums[i])，
        // 则说明 key + num[i] = target，是要寻找的元素，所提返回该key对应的value和当前遍历的元素下标
        Map<Integer, Integer> map = new HashMap<Integer, Integer>(nums.length);
        for (int i = 0; i < nums.length; i++)  {
            // target = nums[i] + xxx
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }

    public static int[] twoNumTest(int[] array, int target) {
        Map<Integer, Integer> map = new HashMap<>(array.length);
        for (int i = 0; i < array.length; i++) {
            int key = target - array[i];
            if (map.containsKey(key)) {
                return new int[] {map.get(key), i};
            }
            map.put(array[i], i);
        }
        return new int[0];
    }
}

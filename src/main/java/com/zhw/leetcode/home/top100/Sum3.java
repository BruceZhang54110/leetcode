package com.zhw.leetcode.home.top100;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = []
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0]
 * 输出：[]
 *  
 *
 * 提示：
 *
 * 0 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class Sum3 {

    public static void main(String[] args) {
        int[] nums = {1, -1, 4, -3, 2, -2, 0, 0, 0};
        List<List<Integer>> lists = threeSum2(nums);
        for (List<Integer> list : lists) {
            for (Integer integer : list) {
                System.out.print(integer + " ");
            }
            System.out.println();
        }
    }

    /**
     * 官方解法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum1(int[] nums) {
        int n = nums.length;
        // 先排序
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        // 枚举a
        for (int first = 0; first < n; first++) {
            // 需要和上次枚举的数不同
            if (first > 0 && nums[first] == nums[first-1]) {
                continue;
            }
            int third = n - 1;
            // 这里置为负数，方便后面计算和为0
            int target = -nums[first];
            // 枚举b
            for (int second = first + 1; second < n; second++) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;
                }
                // 需要保证b的指针在c的指针左侧
                while (second < third && nums[second] + nums[third] > target) {
                    third--;
                }
                // 如果指针重合，随着b的后续增加
                // 就不会有满足 a+b+c=0 并且 b < c 的 c 了，可以退出循环了
                if (second == third) {
                    break;
                }
                if (nums[second] + nums[third] == target) {
                    List<Integer> list = new ArrayList<>(0);
                    list.add(nums[first]);
                    list.add(nums[second]);
                    list.add(nums[third]);
                    ans.add(list);

                }
            }
        }
        return ans;
    }

    /**
     * 网上大神解法
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums == null) {
            return ans;
        }
        if (nums.length < 3) {
            return ans;
        }
        // 从小到大排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length-2; i++) {
            // 第一个数大于0， 后面的数都比他大，肯定不成立
            if (nums[i] > 0) {
                break;
            }
            // 去掉相邻的重复情况
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int target = -nums[i];
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[left] + nums[right] == target) {
                    ans.add(new ArrayList<Integer>(Arrays.asList(nums[i], nums[left], nums[right])));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left-1]) {
                        left++;
                    }
                    while (left < right && nums[right] == nums[right + 1]) {
                        right--;
                    }
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    // nums[left] + nums[right] > target
                    right --;
                }

            }

        }
        return ans;
    }
}

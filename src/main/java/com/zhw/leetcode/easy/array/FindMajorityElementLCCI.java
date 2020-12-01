package com.zhw.leetcode.easy.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中占比超过一半的元素称之为主要元素。给定一个整数数组，找到它的主要元素。若没有，返回-1。
 *
 * 示例 1：
 *
 * 输入：[1,2,5,9,5,9,5,5,5]
 * 输出：5
 *  
 *
 * 示例 2：
 *
 * 输入：[3,2]
 * 输出：-1
 *  
 *
 * 示例 3：
 *
 * 输入：[2,2,1,1,1,2,2]
 * 输出：2
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-majority-element-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindMajorityElementLCCI {
    public static void main(String[] args) {
        int[] nums = {3,2,3,3,3};
        Solution1 s = new Solution1();
        int i = s.majorityElement(nums);
        System.out.println(i);
    }

}
class Solution1 {
    public int majorityElement(int[] nums) {
        int vote = 0;
        int target = 0;

        for (int i = 0; i < nums.length; i++) {
            if(vote==0) {
                target=nums[i];
            }
            if (target == nums[i]) {
                vote ++;
            } else {
                vote --;
            }

        }
        if (vote > 0) {
                int t = 0;
                for(int x : nums)
                    if(x == target)
                        t++;
                if(t > nums.length/2) {
                    return target;
                }
        }
        return -1;
    }
}

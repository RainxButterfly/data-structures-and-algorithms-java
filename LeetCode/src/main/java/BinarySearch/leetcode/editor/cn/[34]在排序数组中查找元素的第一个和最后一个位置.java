/**
 * [34] 在排序数组中查找元素的第一个和最后一个位置
 *
 * @author StarLeaf-Roxy
 * @since 2026-09-20 11:25:46
 */

//给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
//
// Related Topics 数组 二分查找 👍 3308 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        if (nums.length == 0) {
            return ans;
        }
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (nums[m] >= target) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        if (i < nums.length && nums[i] == target) {
            ans[0] = i;
        } else {
            return ans;
        }
        i = 0;
        j = nums.length - 1;
        while (i <= j) {
            int m = (i + j) >>> 1;
            if (nums[m] <= target) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        if (j >= 0 && nums[j] == target) {
            ans[1] = j;
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

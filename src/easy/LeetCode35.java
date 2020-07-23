package easy;


/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 4
 * 输出: 2
 */

public class LeetCode35 {
    public int searchInsert(int[] nums, int target) {
//        for (int i = 0; i< nums.length;i++){
//            if(nums[i]>=target)
//                return i;
//        }
        // 查找第一个>=target的数的下标
        int l = 0, r = nums.length;
        int mid = 0;
        while (l < r) {
            mid = (l + r) / 2;
            if (nums[mid] >= target) {
                r = mid;
            } else {
                l = mid + 1;
            }

        }
        return l;
//        return nums.length;

    }


    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8,10};
        int i = new LeetCode35().searchInsert(nums, 9);
        System.out.println();
    }
}

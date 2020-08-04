package easy;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 */
public class LeetCode154 {
    public static int findMin(int[] nums) {
        int mid, low = 0, high = nums.length-1;
        while (low < high) {
            mid = low + (high - low) / 2; // mid = (l+r)/2可能会发生溢出
            if (nums[mid] < nums[high]) {   // 中间到最右是递增，则最小数位于[最左，中间]
                high = mid;
            } else if(nums[mid] > nums[high]){  // 中间到最右是递减，则最小数位于[中间+1，最右]
                low = mid + 1;
            }else { // 中间等于最右，则不能确定，但是可以high--
                high--;
            }
        }
        return nums[low];
    }

    public static void main(String[] args) {
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(findMin(nums));
    }
}

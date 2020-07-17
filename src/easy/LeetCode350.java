package easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个数组，编写一个函数来计算它们的交集。
 *
 * 示例 1:
 * 输入: nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出: [2,2]
 *
 * 示例 2:
 * 输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出: [4,9]
 *
 * 说明：
 *
 *     输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 *     我们可以不考虑输出结果的顺序。
 */
public class LeetCode350 {

    public int[] intersect(int[] nums1, int[] nums2) {
        // 设num1为长度短的那个
        if (nums1.length > nums2.length) {
            intersect(nums2, nums1);
        }

        // map存了num1中各个数字出现的次数
        HashMap<Integer, Integer> map = new HashMap<>(nums1.length);
        for (int i = 0; i < nums1.length; i++) {
            Integer count = map.getOrDefault(nums1[i], 0) + 1;
            map.put(nums1[i], count);
        }

        // 判断num2中数字是否map中的key
        int[] res = new int[nums1.length];
        int index = 0;
        for (int j = 0; j < nums2.length; j++) {
            int num = nums2[j];
            if (map.containsKey(num) && map.get(num) != 0) {
                res[index++] = num;
                map.put(num, map.get(num) - 1);
            }
        }
        return Arrays.copyOfRange(res, 0, index);
    }


    public static void main(String[] args) {
        int[] num1 = {4,9,5}, num2 = {9,4,9,8,4};
        int[] intersect = new LeetCode350().intersect(num1, num2);
        System.out.println();
    }
}

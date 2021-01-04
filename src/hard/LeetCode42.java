package hard;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 示例 1：
 * <p>
 * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出：6
 * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
 */
public class LeetCode42 {
    public static int trap(int[] height) {
        int len = height.length;
        int ans = 0;
        if(len == 0)
            return ans;
        int[] left_max = new int[len];
        int[] right_max = new int[len];
        left_max[0] = height[0];
        right_max[len - 1] = height[len - 1];
        // 算出i的左边最高的柱子
        for (int i = 1; i < len; i++) {
            left_max[i] = Math.max(left_max[i - 1], height[i]);
        }
        // 算出i的右边最高的柱子
        for (int i = len - 2; i > 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], height[i]);
        }
        for (int i = 1; i < len; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] height = {2, 1, 0, 2, 1, 0, 1, 1, 2, 1, 2, 1};
        int trap = trap(height);
        System.out.println();
    }
}

package mid;

/**
 * 给定一个正整数 n，将其拆分为至少两个正整数的和，并使这些整数的乘积最大化。 返回你可以获得的最大乘积。
 *
 * 示例 1:
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 × 1 = 1。
 *
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36。
 *
 * 说明: 你可以假设 n 不小于 2 且不大于 58。
 */

public class LeetCode343 {
    public static int integerBreak(int n) {
        int sum = 1;
        if (n == 2 || n == 3)
            return n - 1;
        // 在剩余数大于4的时候，尽可能多的取3
        while (n > 4) {
            sum *= 3;
            n = n - 3;
        }
        // 剩余数小于4的时候，直接乘以剩余数
        sum *= n;
        return sum;
    }

    public static void main(String[] args) {
        int i = integerBreak(10);
        System.out.println(i);
    }
}

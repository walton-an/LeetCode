package mid;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 *
 * 示例:
 *
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 *
 *    1         3     3      2      1
 *     \       /     /      / \      \
 *      3     2     1      1   3      2
 *     /     /       \                 \
 *    2     1         2                 3
 *
 * 思路（动态规划）：
 * 1，令G[n]表示n个节点组成的二叉搜索树的个数，f(i,n)表示以i为根节点，n个节点组成的二叉搜索树的个数
 * 则G[n] = f(1,n) + f(2,n) + ... + f(n,n)
 * 2，又因为以i为根节点，n个节点组成的二叉搜索树，它的左节点为1~i-1，右节点为i+1~n
 * 所以f(i,n)= G[i-1]*G[n-i]
 * 所以G[n] = G[0]*G[n-1] + G[1]*G[n-2] + ... + G[n-1]*G[0]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/unique-binary-search-trees
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

public class LeetCode96 {

    public int numTrees(int n) {
        int[] G = new int[n+1];
        // 1个节点跟空数，个数都是为1
        G[0] = 1;
        G[1] = 1;
        // 第一层循环是遍历，依次算出G[2], G[3]...G[n]
        for (int i = 2; i <= n; ++i) {
            // 具体算出G[i]的算法
            for (int j = 1; j <= i; ++j) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }

    public static void main(String[] args) {
        System.out.println(new LeetCode96().numTrees(3));
    }
}

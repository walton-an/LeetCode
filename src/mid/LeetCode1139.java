package mid;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * 给你一个由若干 0 和 1 组成的二维网格 grid，请你找出边界全部由 1 组成的最大 正方形 子网格，并返回该子网格中的元素数量。如果不存在，则返回 0。
 *
 *  示例 1：
 *
 * 输入：grid = [[1,1,1],[1,0,1],[1,1,1]]
 * 输出：9
 *
 * 示例 2：
 *
 * 输入：grid = [[1,1,0,0]]
 * 输出：1
 *
 * 提示：
 *
 *     1 <= grid.length <= 100
 *     1 <= grid[0].length <= 100
 *     grid[i][j] 为 0 或 1
 *
 */

public class LeetCode1139 {
    public int largest1BorderedSquare(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int maxLen = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int curLen = maxLen;

                while (i + curLen < row && j + curLen < col) {
                    // flag1: 以grid[i][j]为首点的边长为maxLen+1的正方形，它的上边和左边是否都为1，flag2则是下边和右边
                    boolean flag1 = true, flag2 = true;

                    // 判断上边和左边
                    for (int a = i + curLen, b = j + curLen; a < i + curLen + 1; a++, b++) {
                        if (grid[a][j] * grid[b][i] == 0) {
                            flag1 = false;
                            break;
                        }
                    }

                    // 上边或者左边存在0的点，则以grid[i][j]为首点的边长为maxLen+1的正方形不存在，直接跳到下一个首点
                    if (!flag1) break;

                    // 判断下边和右边
                    for (int a = i + 1, b = j + 1; a < curLen + 1; a++, b++) {
                        if (grid[a][curLen] * grid[curLen][b] == 0) {
                            curLen++;
                            flag2 = false;
                            break;
                        }
                    }
                    if (!flag2) continue;

                    maxLen = ++curLen;
                }

            }
        }
        return maxLen * maxLen;
    }

    public static void main(String[] args) {
        int[][] grid = {{0,0,0,1}};
        new LeetCode1139().largest1BorderedSquare(grid);
    }
}

package mid;

/**
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像
 *
 *  1，先把二维数组从左到右，从上到下，遍历出来，存至数组
 *  2，再将数组的元素依次填回二维数组（从右往左，一i列一列填满）
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-image
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */

public class LeetCode48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        int[] arr = new int[len * len];
        int count = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                arr[count] = matrix[i][j];
                count++;
            }
        }
        count = 0;
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < len; j++) {
                matrix[j][i] = arr[count];
                count++;
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.println(matrix[i][j]);
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = {{5, 1, 9,11}, {2, 4, 8,10}, {13, 3, 6, 7},{15,14,12,16}};
        new LeetCode48().rotate(matrix);
    }
}

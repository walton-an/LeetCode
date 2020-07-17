package mid;

/**
 * 给定一个无向图graph，当这个图为二分图时返回true。
 *
 * 如果我们能将一个图的节点集合分割成两个独立的子集A和B，并使图中的每一条边的两个节点一个来自A集合，一个来自B集合，我们就将这个图称为二分图。
 *
 * graph将会以邻接表方式给出，graph[i]表示图中与节点i相连的所有节点。每个节点都是一个在0到graph.length-1之间的整数。这图中没有自环和平行边： graph[i] 中不存在i，并且graph[i]中没有重复的值。
 *
 *
 * 示例 1:
 * 输入: [[1,3], [0,2], [1,3], [0,2]]
 * 输出: true
 * 解释:
 * 无向图如下:
 * 0----1
 * |    |
 * |    |
 * 3----2
 * 我们可以将节点分成两组: {0, 2} 和 {1, 3}。
 *
 *
 * 示例 2:
 * 输入: [[1,2,3], [0,2], [0,1,3], [0,2]]
 * 输出: false
 * 解释:
 * 无向图如下:
 * 0----1
 * | \  |
 * |  \ |
 * 3----2
 * 我们不能将节点分割成两个独立的子集。
 *
 * 注意:
 *
 *     graph 的长度范围为 [1, 100]。
 *     graph[i] 中的元素的范围为 [0, graph.length - 1]。
 *     graph[i] 不会包含 i 或者有重复的值。
 *     图是无向的: 如果j 在 graph[i]里边, 那么 i 也会在 graph[j]里边。
 *
 */
public class LeetCode785 {
    /**
     * 任选一个节点开始，给它染成红色。随后我们对整个图进行遍历，将该节点直接相连的所有节点染成绿色，表示这些节点不能与起始节点属于同一个集合。
     * 我们再将这些绿色节点直接相连的所有节点染成红色，以此类推，直到无向图中的每个节点均被染色。
     *
     */
    private boolean valid = true;
    public boolean isBipartite(int[][] graph) {
        // 1，初始化color[]数组，此时值为0，代表所有节点均未被染色，1代表红色，2代表绿色
        int[] color = new int[graph.length];
        for (int i = 0; i < graph.length && valid; i++) {
            // 2，从第一个节点开始，将其染成红色（color[i] == 1）
            if (color[i] == 0) {
                color[i] = 1;
                setColor(i, 1, color, graph);
            }
        }
        return valid;
    }

    public void setColor(int index, int curColor, int[] color, int[][] graph) {
        int newColor = curColor == 1 ? 2 : 1;
        // 3，拿到这个节点相连的所有节点
        for (int i : graph[index]) {
            // 4，如果其未被染色，则将其染成与它的母节点相反的颜色
            if (color[i] == 0) {
                color[i] = newColor;
                // 5，递归，依次遍历与该节点相连的其它节点，将其染色
                setColor(i, newColor, color, graph);
            } else if (color[i] != newColor) { // 6，如果已被染色，判断颜色与它的母节点颜色相反
                valid = false;
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = {{1}, {0,3}, {3}, {1,2}};
        boolean bipartite = new LeetCode785().isBipartite(graph);
        System.out.println();
    }


}

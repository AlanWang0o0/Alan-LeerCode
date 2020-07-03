package LeetCode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class T378Kth_Smallest_Element_in_a_Sorted_Matrix {
    public static void main(String[] args){
        System.out.println(kthSmallest(new int[][]{{1,5,9},{10,11,13},{12,13,15}},8));
    }

    // 转换为一维数组
//    public static int kthSmallest(int[][] matrix, int k) {
//        int rows = matrix.length, columns = matrix[0].length;
//        int[] sorted = new int[rows * columns];
//        int index = 0;
//        for (int[] row : matrix) {
//            for (int num : row) {
//                sorted[index++] = num;
//            }
//        }
//        Arrays.sort(sorted);
//        return sorted[k - 1];
//    }

    // 优先队列,太NB了
    public static int kthSmallest(int[][] matrix, int k) {
        // 存储一个数组的优先队列，每个数组三个数：value，row，column
        // 重写comparator
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        int n = matrix.length;
        // 先将第一列的所有数放到优先队列，整个矩阵得最小值一定在这其中
        for (int i = 0; i < n; i++) {
            pq.offer(new int[]{matrix[i][0], i, 0});
        }
        // 弹出 k-1 次最小值
        for (int i = 0; i < k - 1; i++) {
            int[] now = pq.poll();  // 弹出这个最小值
            //当弹出的这个数不是本行最后一个数时，将这个数后面一个数添加到优先队列中
            if (now[2] != n - 1) {
                // now[1]行,now[2]+1列
                pq.offer(new int[]{matrix[now[1]][now[2] + 1], now[1], now[2] + 1});
            }
        }
        return pq.poll()[0];
    }

}

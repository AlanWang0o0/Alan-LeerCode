package LeetCode;

import java.util.Arrays;
import java.util.Stack;

/***
 * T739:每日温度
 * 根据每日 气温 列表，请重新生成一个列表，对应位置的输出是需要再等待多久温度才会升高超过该日的天数。如果之后都不会升高，请在该位置用 0 来代替。
 *
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 */
public class T739 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }

    /***
     * 暴力求解法
     * 执行用时 : 1688 ms, 在所有 Java 提交中击败了5.02%的用户
     * 内存消耗 : 48.1 MB, 在所有 Java 提交中击败了6.45%的用户
     * @param T
     * @return
     */
//    public static int[] dailyTemperatures(int[] T) {
//        int[] result = new int[T.length];
//        for (int i = 0; i < T.length; i++) {
//            for(int j = i; j < T.length; j++) {
//                if(T[j]>T[i]){
//                    result[i] = j-i;
//                    break;
//                }
//                if(j == T.length-1 && T[j]<=T[i]) break;
//            }
//        }
//        return result;
//    }

    // 递减栈
//    public static int[] dailyTemperatures(int[] T){
//        if (T == null || T.length == 0) return new int[0];
//        Stack<Integer> stack = new Stack<>();
//        int[] result = new int[T.length];
//
//        for (int i = 0; i < T.length; i++) {
//            while(!stack.empty() && T[i] > T[stack.peek()]){
//                int index = stack.pop();
//                result[index] = i - index;
//            }
//            stack.push(i);
//        }
//        return result;
//    }

    /*** 无名方法
     * 执行用时 : 4 ms, 在所有 Java 提交中击败了 98.69% 的用户
     * 内存消耗 : 48.2 MB, 在所有 Java 提交中击败了 6.45% 的用户
     * @param T
     * @return
     */
    public static int[] dailyTemperatures(int[] T){
        int[] result = new int[T.length];
        for (int i = T.length-2; i >=0 ; i--) {   //从后往前
            int j = i+1;
            while (j < T.length){
                if(T[j]>T[i]){     // 大于直接设置
                    result[i] = j-i;
                    break;
                }
                else if(result[j]==0){   // j <= i，并且j后没有比j大的值，那么一定没有比i大的值
                    break;
                }
                else{
                    j += result[j];   // 跳跃到下一个较大值,节省时间
                }
            }
        }
        return result;
    }
}

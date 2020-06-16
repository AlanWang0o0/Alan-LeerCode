package LeetCode;

import java.util.Arrays;

public class T1300 {
    public static void main(String[] args){
        System.out.println(findBestValue(new int[]{4,9,3},10));
    }
//    public static int findBestValue(int[] arr, int target){
//        Arrays.sort(arr);
//        int sum = 0;
//        for (int i = 0; i < arr.length; i++) {
//            int temp = (target-sum)/(arr.length-i);
//            if(temp <= arr[i]){ // 检验结果是否小于下一个数
//                double left = (target*1.0 - sum)/(arr.length-i) - temp;
//                if(left>0.5)    return temp+1;
//                else return temp;
//            }
//            sum += arr[i];
//        }
//        return arr[arr.length-1];
//    }
    // 枚举+二分查找
    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int[] prefix = new int[n + 1];    // 记录前n个值的和，减少求和时间
        for (int i = 1; i <= n; ++i) {
            prefix[i] = prefix[i - 1] + arr[i - 1];
        }
        int r = arr[n - 1];
        int ans = 0, diff = target;
        for (int i = 1; i <= r; ++i) {
            // binarySearch返回值：
            // 如果key在数组中，则返回搜索值的索引；否则返回-1或“-”（插入点）
            // 。插入点是索引键将要插入数组的那一点，即第一个大于该键的元素的索引。
            int index = Arrays.binarySearch(arr, i);
            if (index < 0) {
                index = -index - 1;
            }
            int cur = prefix[index] + (n - index) * i;
            if (Math.abs(cur - target) < diff) {   // 找到与target差最小的值
                ans = i;
                diff = Math.abs(cur - target);
            }
        }
        return ans;
    }
}

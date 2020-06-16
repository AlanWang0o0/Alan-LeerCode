package LeetCode;

import java.util.Arrays;

public class T1300 {
    public static void main(String[] args){
        System.out.println(findBestValue(new int[]{4,9,3},10));
    }
    public static int findBestValue(int[] arr, int target){
        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int temp = (target-sum)/(arr.length-i);
            if(temp <= arr[i]){ // 检验结果是否小于下一个数
                double left = (target*1.0 - sum)/(arr.length-i) - temp;
                if(left>0.5)    return temp+1;
                else return temp;
            }
            sum += arr[i];
        }
        return arr[arr.length-1];
    }
}

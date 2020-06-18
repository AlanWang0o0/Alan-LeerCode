package LeetCode;


import java.util.Arrays;

public class T1014 {
    public static void main(String[] args){
        System.out.println(maxScoreSightseeingPair(new int[]{8,1,5,2,6}));
    }
    // 暴力求解
    public static int maxScoreSightseeingPair(int[] A) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            for(int j=i+1 ; j<A.length ; j++){
                if(A[i]+A[j]+i-j>max){
                    max = A[i]+A[j]+i-j;
                }
            }
        }
        return max;
    }

//    public static int maxScoreSightseeingPair(int[] A) {
//        int len= A.length;
//        int max = Integer.MIN_VALUE, temp = A[0];
//        for (int i = 1; i < len; i++) {
//            // 边遍历边更新
//            max = Math.max(max, temp + A[i] - i);
//            temp = Math.max(temp, A[i] + i);
//        }
//        return max;
//    }

}

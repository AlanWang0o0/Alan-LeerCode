package LeetCode;

public class T718_Maximum_Length_of_Repeated_Subarray {
    public static void main(String[] args){
//        System.out.println(findLength(new int[]{1,2,3,2,1},new int[]{3,2,1,4,7}));
//        System.out.println(findLength(new int[]{1,0,0,0,0},new int[]{0,0,0,0,1}));
        System.out.println(findLength(new int[]{0,0,0,0,0,0,1,0,0,0},new int[]{0,0,0,0,0,0,0,1,0,0}));
    }
    public static int findLength(int[] A, int[] B) {
        int i,j;
        int len = 0;
        int[][] dp = new int[A.length + 1][B.length + 1]; //建立一个二维表,横向为 A数组，纵向为 B 数组。
        for(i = 1; i <= A.length; i++){
            for(j = 1; j <= B.length; j++){
                if(A[i - 1] == B[j - 1]){     //如果两个元素相等，就看他前面一个元素匹配的结果。
                    dp[i][j] = dp[i - 1][j - 1] + 1;    // 递推公式
                }
                len = Math.max(len,dp[i][j]);
            }
        }
        return len;
    }
}

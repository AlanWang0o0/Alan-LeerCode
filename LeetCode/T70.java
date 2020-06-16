package LeetCode;

public class T70 {
    public static void main(String[] args) {
        System.out.println(climbStairs(40));
    }

    // 递归
//    public static int climbStairs(int n) {
//         if(n == 1) return 1;
//         else if(n == 0) return 1;
//         return climbStairs(n-1) + climbStairs(n-2);
//    }

    // 递归，数组存储结果
//    public static int climbStairs(int n) {
//
//         if(n==0) return 0;
//         else if(n==1) return 1;
//         int[] res = new int[n+1];
//         res[0] = 1;
//         res[1] = 1;
//         for(int i=2 ; i<=n ; i++){
//             res[i] = res[i-1] + res[i-2];
//         }
//         return res[n];
//    }

    // 滑动数组
    public static int climbStairs(int n) {
        // 空间优化
        if(n<=2)    return n;
        int i1 = 1;
        int i2 = 2;
        for(int i=3;i<=n;i++){
            int temp = i1+i2;
            i1 = i2;
            i2 = temp;
        }
        return i2;
    }
}

package LeetCode;

public class T41_First_Missing_Positive {
    public static void main(String[] args){
        System.out.println(firstMissingPositive(new int[]{1,2,0}));
    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            // 数值再[0,n-1]的范围内。（nums[i] != nums[nums[i]-1]防止陷入死循环）
            // 使用while循环因为：换过来的值可能不符合次序
            while( nums[i]>0 &&  nums[i]<n && nums[i] != nums[nums[i]-1]  ){
                int temp = nums[nums[i]-1];    // 这个交换的顺序不能变，因为 nums[i]的值会影响到 nums[nums[i]-1]的值
                nums[nums[i]-1]= nums[i];
                nums[i] = temp;
            }
        }
        for (int i = 0; i < n; i++) {
            if(nums[i] != i+1){     // i+1 位置放置的值应该为 i
                return i+1;     // 第一个不符合次序的值即为缺少的值
            }
        }
        return n+1;
    }
}

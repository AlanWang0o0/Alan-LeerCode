package LeetCode;

import java.util.Arrays;
import java.util.PriorityQueue;

public class T215Kth_Largest_Element_in_an_Array {
    public static void main(String[] args){
        System.out.println(findKthLargest(new int[]{3,2,1,5,6,4},2));
    }

//    public static int findKthLargest(int[] nums, int k) {
//        quickSort(nums,0,nums.length-1);
//        return(nums[nums.length-k]);
//    }
//
//    public static void quickSort(int[] nums, int l, int r){
//        if(l>=r) return;
//        int i=l-1, j=r+1;
//        int flag = nums[(l+r)/2];
//
//        while(i<j){
//            do i++ ; while(nums[i] < flag);
//            do j-- ; while(nums[j] > flag);
//            if(i<j){
//                int temp = nums[i];
//                nums[i] = nums[j];
//                nums[j] = temp;
//            }
//        }
//
//        quickSort(nums,l,j);
//        quickSort(nums,j+1,r);
//    }

    // 最小堆
    public static int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(len);
        for (int num : nums) {
            maxHeap.add(num);
        }
        for (int i = 0; i < len-k; i++) {
            maxHeap.poll();
        }
        return maxHeap.peek();
    }
}

package Sort;

import java.util.Arrays;
import java.util.LinkedList;

public class SortTest {
    public static void main(String[] args){
        SortArray arr = new SortArray(48,100);
        System.out.println(Arrays.toString(arr.getArr()));
//        BubbleSort(arr);
//        SelectionSort(arr);
//        InsectionSort(arr);
//        ShellSort(arr);
//        QuickSort(arr,0,arr.getLen()-1);
//        MergeSort(arr,0,arr.getLen()-1);
//        CountSort(arr);
//        RadixSort(arr,100);
        HeapSort(arr);
        System.out.println(Arrays.toString(arr.getArr()));
    }

    //    选择排序
    public static void SelectionSort(SortArray arr){
        for (int i = 0; i < arr.getLen(); i++) {
            int min = 101;   //由于数组是0-100范围，初始min取为101即可
            int index = 0;  // index记录最小元素的位置
            // 内循环找出最小的元素
            for (int j = i; j < arr.getLen(); j++) {
                if (arr.getNum(j) < min) {
                    index = j;
                    min = arr.getNum(j);
                }
            }
            arr.swap(i,index);    //交换元素
        }
    }

    //    冒泡排序
    public static void BubbleSort(SortArray arr){
        for (int i = 0; i < arr.getLen()-1; i++) {
            for (int j = 0; j < arr.getLen()-i-1; j++) {
                // 两两比较
                if(arr.getNum(j)>arr.getNum(j+1))
                    arr.swap(j,j+1);
            }
        }
    }

    // 插入排序
    public static void InsectionSort(SortArray arr){
        for (int i = 1; i < arr.getLen(); i++) {
            int temp = arr.getNum(i);

            for (int j = i-1; j >=0; j--) {
                // 如果不符合次序就把元素往后移
                if(temp < arr.getNum(j)){
                    arr.swap(j+1,j);
                }
                // 符合次序，直接插入,跳出循环
                else{
                    arr.changeValue(j+1,temp);
                    break;
                }
            }
        }
    }

    // 希尔排序
    public static void ShellSort(SortArray arr){
        for(int step = arr.getLen()/2 ; step > 0 ; step /= 2){
            // 对每一个元素进行组内插入排序
            for (int i = step; i < arr.getLen(); i++) {
                int temp = arr.getNum(i);

                for (int j = i-step; j >= 0 ; j -= step) {

                    if(temp < arr.getNum(j)){
                        arr.swap(j+step,j);
                    }
                    else{
                        arr.changeValue(j+step,temp);
                        break;
                    }

                }
            }
        }
    }

    // 快速排序
    public static void QuickSort(SortArray arr,int low,int high){
        if(low >= high) return;
        int i=low-1,j=high+1;
        int flag = arr.getNum((low+high)/2);

        while(i<j){
            do i++; while(arr.getNum(i)<flag);
            do j--; while(arr.getNum(j)>flag);
            if( i < j ) arr.swap(i,j);
        }

        // 递归左右两个部分
        QuickSort(arr,low,j);
        QuickSort(arr,j+1,high);
    }

    // 归并排序
    public static void MergeSort(SortArray arr,int low, int high){
        if(low>=high)   return;
        int mid = (low+high)/2;

        MergeSort(arr,low,mid);
        MergeSort(arr,mid+1,high);

        int i = 0, j = low, k =mid+1;
        int [] temp = new int[100];

        while(j<=mid && k<=high){
            if(arr.getNum(j)<arr.getNum(k)) temp[i++] = arr.getNum(j++);
            else temp[i++] = arr.getNum(k++);
        }

        while(j<=mid) temp[i++] = arr.getNum(j++);
        while(k<=high) temp[i++] = arr.getNum(k++);

        for (i = low,j = 0; i <= high ; i++,j++) {
            arr.changeValue(i,temp[j]);
        }
    }

    // 计数排序
    public static void CountSort(SortArray arr){
        int min = 101,max = -1;

        // 找到最大值和最小值
        for (int i = 0; i < arr.getLen(); i++) {
            if(arr.getNum(i) < min) min = arr.getNum(i);
            else if(arr.getNum(i)>max) max = arr.getNum(i);
        }

        int[] temp = new int[max-min+1];     // 减小多余空间使用，后面得数以min为基准

        for (int i = 0; i < arr.getLen(); i++) {
            temp[arr.getNum(i)-min] ++;
        }

        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            while(temp[i]>0){
                arr.changeValue(j++,i+min);
                temp[i]--;
            }
        }

    }

    // 桶排序

    // 基数排序
    public static void RadixSort(SortArray arr,int dataWidth){
        int n = 1;   // 数据宽度记录位，记录当前的排序是第几位
        int length = arr.getLen();
        int[][] bucket = new int[10][length];    // 二维数组，存储每次数据的分组结果
        int[] order = new int[10];        // 一维数组，记录0-9每组的数据元素多少

        while(n < dataWidth){
            // 将所有元素按照当前循环的位数，放到对应的桶中
            for (int i = 0; i < arr.getLen(); i++) {
                int temp = (arr.getNum(i)/n)%10;  // 取出对应位数
                bucket[temp][order[temp]++] = arr.getNum(i);
            }
            // 将桶中数据覆盖保存到原数组
            int k = 0;
            for(int i=0; i<10 ;i++) {
                for (int j = 0; j < order[i]; j++) {  // 一定要从小到大遍历，这样才不会破坏以前的排序结果
                    arr.changeValue(k++, bucket[i][j]);
                }
                order[i] = 0;  // order置零
            }
            n *= 10;  // 位数*10,用于下一次排序

        }

    }

    // 堆排序
    public static void HeapSort(SortArray arr) {
        for (int i = (arr.getLen() - 1) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            generateHeap(arr, i, arr.getLen());
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.getLen() - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            arr.swap(0,i);

            //重新对堆进行调整
            generateHeap(arr, 0, i);
        }

    }
    // 生成堆
    public static void generateHeap(SortArray arr,int parent,int length){
        //将temp作为父节点
        int temp = arr.getNum(parent);
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，并且右孩子结点的值大于左孩子结点，则选取右孩子结点
            if (rChild < length && arr.getNum(lChild) < arr.getNum(rChild)) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr.getNum(lChild)) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr.changeValue(parent,arr.getNum(lChild));

            //选取孩子结点的左孩子结点,继续向下筛选
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr.changeValue(parent,temp);
    }
}


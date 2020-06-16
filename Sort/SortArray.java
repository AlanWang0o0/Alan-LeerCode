package Sort;

public class SortArray {
    private int[] arr;
    private int len;

    SortArray(int len,int max){
        this.len = len;
        this.arr = new int[len];
        for (int i = 0; i < len; i++) {
            this.arr[i] = (int) (Math.random() * max);
        }
    }

    public int getLen() {
        return len;
    }

    public int[] getArr() {
        return arr;
    }

    public void swap(int m, int n){
        int temp = this.arr[m];
        this.arr[m] = this.arr[n];
        this.arr[n] = temp;
    }

    public void changeValue(int index,int value){
        this.arr[index] = value;
    }

    public int getNum(int index){
        return this.arr[index];
    }


}

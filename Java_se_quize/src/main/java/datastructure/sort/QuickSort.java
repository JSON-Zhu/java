package datastructure.sort;

import java.util.*;

/**
 * QuickSort
 *
 * @author XQ.Zhu
 * @version 1.0
 * 2022/7/3 21:18
 **/
public class QuickSort {
    public static void main(String[] args) {
        int[] ints = {4,2,7};
        determinePivot(ints,0,2);
    }

    public int[] quickSortByTextbook(int[] arr, int left, int right){
        int pivot=determinePivot(arr,left,right);
        int i=left,j=right-1;
        HashMap<Object, Object> map = new HashMap<>();

        for (;;){
            break;
        }
        return arr;
    }

    private static int determinePivot(int[] arr, int left, int right) {
        int center=(left+right)>>>1;
        //比较left, center
        if(arr[left]>arr[center]){
            swap(arr,arr[left],arr[center]);
        }
        //比较left,right
        if (arr[left]>arr[right]) {
            swap(arr, left, right);
        }
        //比较center,right
        if(arr[center]>arr[right]){
            swap(arr, center, right);
        }
        //隐藏pivot
        swap(arr,center,right-1);
        //返回pivot
        return arr[right-1];
    }

    private static void swap(int[] arr, int i, int i1) {
        int temp=arr[i];
        arr[i]=arr[i1];
        arr[i1]=temp;
    }

}

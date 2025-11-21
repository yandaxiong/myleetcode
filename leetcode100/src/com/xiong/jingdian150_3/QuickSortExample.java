package com.xiong.jingdian150_3;

import com.xiong.utils.OutArrays;

/**
 * @author xiong
 * @create 2025-11-21-11:15
 */
public class QuickSortExample {

    public static void quickSort(int[] arr, int low, int high) {
       if(low<high){
           int pivotIndex = partition(arr, low, high);
           quickSort(arr, low, pivotIndex-1);
           quickSort(arr,pivotIndex+1,high);
       }
    }

//    8, 3, 5, 1, 9, 6
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int leftIndex = low-1;
        for (int i=low;i<high;i++){
            if(arr[i]<=pivot){
                leftIndex++;
                if(leftIndex != i){
                    int tmp = arr[leftIndex];
                    arr[leftIndex] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        int tmp = arr[leftIndex+1];
        arr[leftIndex+1] = arr[high];
        arr[high] = tmp;
        return leftIndex+1;
    }

    // 测试快速排序方法的主函数
    public static void main(String[] args) {
        // 定义一个需要排序的数组
        int[] arr = {8, 3, 5, 1, 9, 6};

        // 打印排序前的数组
        System.out.println("排序前的数组：");
        printArray(arr);

        // 调用快速排序方法，排序整个数组
        quickSort(arr, 0, arr.length - 1);

        // 打印排序后的数组
        System.out.println("排序后的数组：");
        printArray(arr);
    }

    // 辅助方法：打印数组中的所有元素
    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

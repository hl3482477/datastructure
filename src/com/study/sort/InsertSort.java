package com.study.sort;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2020/7/9 9:39
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 89};
        insertSort2(arr);
        System.out.println(Arrays.toString(arr));
    }

    //插入排序
    public static void insertSort(int[] arr) {
        int insertVal = 0;
        int insertIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            insertVal = arr[i]; //待插入的值
            insertIndex = i - 1;
            // 给insertVal 找到插入的位置
            // 说明
            // 1. insertIndex >= 0 保证在给insertVal 找插入位置，不越界
            // 2. insertVal < arr[insertIndex] 待插入的数，还没有找到插入位置
            // 3. 就需要将 arr[insertIndex] 后移
            while (insertIndex >= 0 && insertVal < arr[insertIndex]) {
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }

            arr[insertIndex + 1] = insertVal;

        }
    }


    //插入排序
    public static void insertSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int temp = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0 && arr[j] > arr[j + 1]; j--) {
              /*  temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;*/
                swap(arr,j,j+1);
            }
        }
    }


    public static void swap(int[] arr, int i, int j) {
        arr[i] = arr[i] ^ arr[j];
        arr[j] = arr[i] ^ arr[j];
        arr[i] = arr[i] ^ arr[j];
    }
}

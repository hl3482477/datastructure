package com.study.sort;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2020/7/6 11:05
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] arr = {101, 34, 119, 1, -1, 90, 123};
        System.out.println("排序前");
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println("排序后");
        System.out.println(Arrays.toString(arr));
    }


    //选择排序
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndx = i;
            int min = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndx = j;
                }
            }
            if (minIndx != i) {
                //交换
                arr[minIndx] = arr[i];
                arr[i] = min;
            }
            System.out.println("第" + (i + 1) + "轮后~~");
            System.out.println(Arrays.toString(arr));// 1, 34, 119, 101
        }
    }


    public static void selectSort2(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            int min =arr[i];
            for (int j=i+1;j<arr.length;j++){
                if (min>arr[j]){
                    min=arr[j];
                    minIndex=j;
                }
            }
            if (minIndex!=i){
                arr[minIndex] =arr[i];
                arr[i] =min;
            }
        }

    }
}

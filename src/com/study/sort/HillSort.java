package com.study.sort;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2020/7/10 13:59
 */
public class HillSort {
    public static void main(String[] args) {

        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};

        shellSort2(arr);

        System.out.println(Arrays.toString(arr));
    }


    //交换式，效率较低
    public static void shellSort(int[] arr) {
        int temp = 0;
        for (int gep = arr.length / 2; gep > 0; gep = gep / 2) {
            for (int i = gep; i < arr.length; i++) {
                // 遍历各组中所有的元素(共gap组，每组有个元素), 步长gap
                for (int j = i - gep; j >= 0; j -= gep) {
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j + gep]) {
                        temp = arr[j];
                        arr[j] = arr[j + gep];
                        arr[gep + j] = temp;
                    }
                }
            }
        }
    }

    //对交换式的希尔排序进行优化->移位法
    public static void shellSort2(int[] arr) {
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            // 从第gap个元素，逐个对其所在的组进行直接插入排序
            for (int i = gap; i < arr.length; i++) {
                int j =i;
                int temp =arr[i];
                if (arr[j]<arr[j-gap]){
                    while (j-gap>=0 && temp<arr[j-gap]){
                        //移动
                        arr[j]=arr[j-gap];
                        j-=gap;
                    }
                    //当退出while后，就给temp找到插入的位置
                    arr[j]=temp;
                }

            }
        }
    }
}

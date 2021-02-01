package com.study.sort;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2020/7/10 17:02
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9, 78, 0, 23, -567, 70, -1, 900, 4561};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("arr=" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        int tempValue = arr[(left+right)/2];
        while (l<r){

            while (arr[l]<tempValue){
                l++;
            }
            while (arr[r]>tempValue){
                r--;
            }
            if (l>=r){
              break;
            }
            temp=arr[l];
            arr[l]=arr[r];
            arr[r]=temp;

            if (arr[l]==tempValue){

                r--;
            }
            if (arr[r]==tempValue){
                l++;
            }
        }

        if (l==r){
            l++;
            r--;
        }

        if (l<right){
            quickSort(arr,l,right);
        }
        if (r>left){
            quickSort(arr,left,r);
        }
    }




























   /* public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int privot = arr[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (arr[l] < privot) {
                l += 1;
            }
            while (arr[r] > privot) {
                r -= 1;
            }

            if (l >= r) {
                break;
            }
            //交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l] == privot) {
                r -= 1;
            }
            if (arr[r] == privot) {
                l += 1;
            }
        }

        // 如果 l == r, 必须l++, r--, 否则为出现栈溢出
        if (l == r) {
            l += 1;
            r -= 1;
        }

        //向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }

        //向右递归
        if (right > l) {
            quickSort(arr, l, right);
        }

    }*/
}

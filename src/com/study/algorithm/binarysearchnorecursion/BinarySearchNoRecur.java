package com.study.algorithm.binarysearchnorecursion;

/**
 * 二分查找非递归方式
 * @author HULU
 * @version 创建时间：2020/8/26 18:22
 */
public class BinarySearchNoRecur {
    public static void main(String[] args) {
        //测试
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int index = binarySearch(arr, 100);
        System.out.println("index=" + index);//
    }

    public static int binarySearch(int arr[],int num){
       int right = arr.length-1;
       int  left = 0;
       while (left<=right){
           int mid  = (right+left)/2;
           if (arr[mid] ==num){
               return mid;
           } else if (num<arr[mid]){
               right = mid-1;
           }else {
               left = mid+1;
           }
       }
       return -1;
    }
}

package com.study.search;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HULU
 * @version 创建时间：2020/7/17 11:33
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 8, 10, 89, 1000, 1000, 1234};
        /*int resIndex = binarySearch(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndex=" + resIndex);*/
        List<Integer> resIndexList = binarySearch2(arr, 0, arr.length - 1, 1000);
        System.out.println("resIndexList=" + resIndexList);
    }


    // 二分查找算法

    /**
     * @param arr     数组
     * @param left    左边的索引
     * @param right   右边的索引
     * @param findVal 要查找的值
     * @return 如果找到就返回下标，如果没有找到，就返回 -1
     */
    public static int binarySearch(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (findVal < arr[mid]) {
            return binarySearch(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return binarySearch(arr, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) {
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        if (findVal < arr[mid]) {
            return binarySearch2(arr, left, mid - 1, findVal);
        } else if (findVal > arr[mid]) {
            return binarySearch2(arr, mid + 1, right, findVal);
        } else {
            List<Integer> resIndexlist = new ArrayList<Integer>();
            int temp = mid-1;
            while (true){
                if (temp<0 || arr[temp]!=findVal){
                    break;
                }
                resIndexlist.add(temp);
                temp-=1;
            }
            resIndexlist.add(temp);
            temp = mid + 1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!=findVal){
                    break;
                }
                resIndexlist.add(temp);
                temp+=1;
            }
            return resIndexlist;
        }

    }
}

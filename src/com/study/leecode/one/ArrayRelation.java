package com.study.leecode.one;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2021/1/29 14:00
 */
public class ArrayRelation {

    public static void main(String[] args) {
        /*int i = missingNumber(new int[]{0, 1, 2, 4, 5});
        System.out.println(i);*/
        double a = 1.0000000149011612;
        System.out.println(a>0 && a<1);
    }

    /**
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
     * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
     * 链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
     *
     * @param nums
     * @return
     */
    public static int missingNumber(int[] nums) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] == mid) {
                left = mid + 1;
            } else {
               right =mid;
            }
        }
        return left;
    }

    /**
     * 给定一个数组nums，查找一个元素，使其比排在他前面的元素都比他大
     */
}

package com.study.leecode.one;

import java.util.Queue;

/**
 * @Description
 * @Author hulu@codemao.cn
 * @Date 2021/5/16 3:12 下午
 **/
public class Exercise20210516 {

    public static void main(String[] args) {

    }

    /**
     * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
     * 如果反转后整数超过 32 位的有符号整数的范围[−231, 231− 1] ，就返回 0。
     * 假设环境不允许存储 64 位整数（有符号或无符号）。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            //x大于2的31次方
            if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp > 7)) {
                return 0;
            }
            //x小于负2的31次方-1
            if (result < Integer.MIN_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && temp < -8)) {
                return 0;
            }
            result = result * 10 + temp;
            x = x / 10;
        }
        return result;
    }

    /**
     * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
     * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     *
     * @param x
     * @return
     */
    public boolean isPalindrome(int x) {
        //如果是负数则一定不是回文数，直接返回 false
        //如果是正数，则将其倒序数值计算出来，然后比较和原数值是否相等
        if (x < 0) {
            return false;
        }
        int num = x;
        int result = 0;
        while (x != 0) {
            int temp = x % 10;
            result = result * 10 + temp;
            x = x / 10;
        }
        //result为倒序数值
        return result == num;
    }
}

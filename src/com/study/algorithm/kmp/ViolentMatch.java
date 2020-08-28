package com.study.algorithm.kmp;

/**
 * @author HULU
 * @version 创建时间：2020/8/28 14:06
 */
public class ViolentMatch {

    public static void main(String[] args) {
               //测试暴力匹配算法
        String str1 = "硅硅谷 尚硅谷你尚硅 尚硅谷你尚硅谷你尚硅你好";
        String str2 = "尚硅谷你尚硅你";
        int index = voilentMatch(str1, str2);
        System.out.println("index=" + index);
    }

    public static int voilentMatch(String str1 , String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2len = s2.length;
        int i=0,j=0;
        while (i<s1Len && j<s2len){
            if (s1[i]==s2[j]){
                i++;
                j++;
            }else {
                i = i-(j-1);
                j=0;
            }
        }
        if (j==s2len){
            return  i-j;
        }else {
            return  -1;
        }
    }
}

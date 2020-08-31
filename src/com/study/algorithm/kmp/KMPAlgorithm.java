package com.study.algorithm.kmp;

import java.util.Arrays;

/**
 * @author HULU
 * @version 创建时间：2020/8/28 15:14
 */
public class KMPAlgorithm {
    public static void main(String[] args) {

        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        String s = str2.replaceAll("C","");
        System.out.println(s);
        //String str2 = "BBC";

        int[] next = kmpNext("ABCDABD"); //[0, 1, 2, 0]
        System.out.println("next=" + Arrays.toString(next));

        int index = kmpSearch(str1, str2, next);
        System.out.println("index=" + index); // 15了
    }

    public static int kmpSearch(String str1,String str2,int [] next){
        for(int i=0,j=0;i<str1.length();i++){
            while (j>0 && str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }

            if ((j==str2.length())){
               // 找到了
                return i-j+1;
            }
        }
        return -1;
    }

    //获取到一个字符串(子串) 的部分匹配值表
    public static int [] kmpNext(String dest){
        //创建一个next 数组保存部分匹配值
        int [] next = new int[dest.length()];
        //如果字符串是长度为1 部分匹配值就是0
        next[0] =0;
        for (int i =1 ,j=0;i<dest.length();i++){
            while(j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j-1];
            }

            if (dest.charAt(i)==dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}

package com.study.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HULU
 * @version 创建时间：2020/9/1 17:26
 */
public class Test3 {
    public static void main(String[] args) {
        findContinuousSequence(9);
    }

    public static int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int l =0;
        for(int i =1;i<target;i++){
            int sum =0,j=0,k=i;
            int [] temp =new int[target];
            while(sum<target){

                sum +=k;
                temp[j] = k;
                if(sum>target){
                    break;
                }
                if(sum==target){
                    list.add(temp);
                    l++;
                }
                j++;
                k++;
            }
        }


        int[][] res = new int[list.size()][];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }
        return res;

    }
}

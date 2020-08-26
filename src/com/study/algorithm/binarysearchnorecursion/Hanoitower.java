package com.study.algorithm.binarysearchnorecursion;

/**
 * @author HULU
 * @version 创建时间：2020/8/26 18:38
 */
public class Hanoitower {
    public static void main(String[] args) {
        hanoTower(10, 'A', 'B', 'C');
    }
    //汉诺塔的移动的方法
    //使用分治算法
    public static  void  hanoTower(int num, char A, char B ,char C){
        //如果只有一个盘
        if (num == 1){
            System.out.println("第1个盘从 " + A + "->" + C);
        }else {
            //如果我们有 n >= 2 情况，我们总是可以看做是两个盘 1.最下边的一个盘 2. 上面的所有盘
            //1. 先把 最上面的所有盘 A->B， 移动过程会使用到 c
            hanoTower(num-1,A,C,B);
            //2. 把最下边的盘 A->C
            System.out.println("第"+num+"个盘从 " + A + "->" + C);
            //3. 把B塔的所有盘 从 B->C , 移动过程使用到 a塔
            hanoTower(num-1,B,A,C);
        }
    }
}

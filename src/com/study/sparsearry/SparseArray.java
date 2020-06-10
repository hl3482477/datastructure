package com.study.sparsearry;

/**
 * Created by 胡露
 * create time 2020/6/7 14:06
 */
public class SparseArray {

    public static void main(String[] args) {
        //先创建二维数组  11x11
        int array [][] =new int[11][11];
        array[1][2]=1;
        array[2][3]=2;
        System.out.println("输出原始数组");
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }

        int sum =0;
        //获取非0的个数
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (array[i][i1]!=0){
                   sum++;
                }
            }
        }
        System.out.println("sum="+sum);

        int array2[][] =new int[sum+1][3];
        array2[0][0] =11;
        array2[0][1]=11;
        array2[0][2]=sum;

        int count =0;
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (array[i][i1]!=0){
                    count++;
                    array2[count][0] = i;
                    array2[count][1] = i1;
                    array2[count][2] = array[i][i1];
                }
            }
        }

        System.out.println("输出稀疏矩阵");
        for (int i = 0; i < array2.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",array2[i][0],array2[i][1],array2[i][2]);
        }
        System.out.println("");

        int array3 [][] = new int[array2[0][0]][array2[0][1]];

        for (int i = 1; i < array2.length; i++) {
            array3[array2[i][0]][array2[i][1]] =array2[i][2];
        }

        for (int[] ints : array3) {
            for (int anInt : ints) {
                System.out.printf("%d\t",anInt);
            }
            System.out.println();
        }
    }
}

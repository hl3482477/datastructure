package com.study.tree;

/**
 * 顺序存储二叉树
 *
 * @author HULU
 * @version 创建时间：2020/7/21 16:28
 */
public class ArrayBinaryTreeDemo {
    public static void main(String[] args) {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(arr);
        arrBinaryTree.preOrder(0); // 1,2,4,5,3,6,7
    }
}

class ArrBinaryTree {
    private int[] arr;//存储数据结点的数组

    public ArrBinaryTree(int[] arr) {
        this.arr = arr;
    }

    public void preOrder(int index) {
        if (arr == null || arr.length == 0) {

            System.out.println("数组为空，不能按照二叉树的前序遍历");
        }
        System.out.println(arr[index]);
        if ((index * 2 + 1) < arr.length) {
            //顺序二叉树n的左子节点是2n+1，右子节点是2n+2
            preOrder(index * 2 + 1);
        }
        if ((index * 2 + 2) < arr.length) {
            //顺序二叉树n的左子节点是2n+1，右子节点是2n+2
            preOrder(index * 2 + 2);
        }
    }
}


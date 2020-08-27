package com.study.huffmantree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author HULU
 * @version 创建时间：2020/8/25 9:34
 */
public class HuffmanTree {
    public static void main(String[] args) {
        int arr[] = {13, 7, 8, 3, 29, 6, 1};
        Node root = createHuffmanTree(arr);

        //测试一把
        preOrder(root); //
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root) {
        if (root != null) {
            root.preOrder();
        } else {
            System.out.println("是空树，不能遍历~~");
        }
    }

    public static Node createHuffmanTree(int[] arr) {
        List<Node> nodes = new ArrayList<>();
        //创建节点并加入List
        for (int i = 0; i < arr.length; i++) {
            nodes.add(new Node(arr[i]));
        }
        while (nodes.size() > 1) {
            //排序
            Collections.sort(nodes);
            Node left = nodes.get(0);
            Node right = nodes.get(1);
            Node node = new Node(left.data + right.data);
            node.left = left;
            node.right = right;
            nodes.remove(left);
            nodes.remove(right);
            nodes.add(node);
        }
        return nodes.get(0);
    }
}

class Node implements Comparable<Node> {
    int data;
    char c;
    Node left;
    Node right;

    //写一个前序遍历
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }

        if (this.right != null) {
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }

    public Node(int data) {
        this.data = data;
    }

    @Override
    public int compareTo(Node o) {
        // 表示从小到大排序
        return this.data - o.data;
    }
}

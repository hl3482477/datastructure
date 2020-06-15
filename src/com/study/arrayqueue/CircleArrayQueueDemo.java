package com.study.arrayqueue;

/**
 * 环形队列
 *
 * @author HULU
 * @version 创建时间：2020/6/12 14:56
 */

public class CircleArrayQueueDemo {

    public static void main(String[] args) {

    }

}


class CircleArray {

    private int front; //这里就是第一个元素
    private int rear;  //指向队列的最后一个元素的后一个位置
    private int maxSize;
    private int arr[];

    public CircleArray(int max) {
        maxSize = max;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public void add(int n) {
        if (isFull()) {
            System.out.println("队列已满");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;

    }

    public int remove() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，不能取数据");
        }
        //front就是头元素
        int v = arr[front];
        front = (front + 1) % maxSize;
        return v;
    }

    public int getHeader() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }
        return arr[front];
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void show() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空，没有数据");
        }

        for (int i = front; i < front + size(); i++) {
            System.out.println(arr[front]);
        }

    }

}
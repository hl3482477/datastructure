package com.study.arrayqueue;

/**
 * @author HULU
 * @version 创建时间：2020/6/16 16:20
 */
public class Josepfu {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);// 加入5个小孩节点
        circleSingleLinkedList.showBoy();
    }
}


class CircleSingleLinkedList {
    // 创建一个first节点,当前没有编号
    private Boy first = null;

    public void addBoy(int n) {
        if (n < 1) {
            System.out.println("n的值不正确");
            return;
        }
        Boy curBoy = null; // 辅助指针，帮助构建环形链表
        for (int i = 1; i <= n; i++) {
            Boy boy = new Boy(i);
            if (i==1){
                //首个节点
                first = boy;
                first.setNext(first);
                curBoy=first;
            }else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy=boy;

            }
        }
    }


    // 遍历当前的环形链表
    public void showBoy() {
        if (first == null) {
            System.out.println("没有任何小孩~~");
            return;
        }
        Boy cur =first;
        while (true){
            System.out.println(cur.getNo());
           if (cur.getNext()==first){
               break;
           }
           cur = cur.getNext();
        }
    }

    // 根据用户的输入，计算出小孩出圈的顺序
    /**
     *
     * @param startNo
     *            表示从第几个小孩开始数数
     * @param countNum
     *            表示数几下
     * @param nums
     *            表示最初有多少小孩在圈中
     */
    public void countBoy(int startNo, int countNum, int nums) {
        //先对数据进行校验
        if (startNo<1 || countNum>nums || first ==null){
            System.out.println("参数输入有误， 请重新输入");
            return;
        }

    }
}

class Boy {
    private int no;
    private Boy next;//指向下一个节点,默认null

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
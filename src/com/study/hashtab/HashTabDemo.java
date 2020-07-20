package com.study.hashtab;

import java.util.Scanner;

/**
 * @author HULU
 * @version 创建时间：2020/7/20 15:05
 */
public class HashTabDemo {
    public static void main(String[] args) {
        //创建哈希表
        HashTab hashTab = new HashTab(7);

        //写一个简单的菜单
        String key = "";
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key = scanner.next();
            switch (key) {
                case "add":
                    System.out.println("输入id");
                    int id = scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    //创建 雇员
                    Emp emp = new Emp(id, name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "find":
                    System.out.println("请输入要查找的id");
                    id = scanner.nextInt();
                    hashTab.findEmpById(id);
                    break;
                case "exit":
                    scanner.close();
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}

class HashTab {
    private EmpLinkedList[] empLinkedLists;
    private int size;

    public HashTab(int size) {
        this.size = size;
        empLinkedLists = new EmpLinkedList[size];
        for (int i = 0; i < size; i++) {
            empLinkedLists[i] = new EmpLinkedList();
        }
    }

    //添加雇员
    public void add(Emp emp) {
        int i = hashFun(emp.id);
        empLinkedLists[i].add(emp);
    }

    public void list() {
        for (int i = 0; i < size; i++) {
            empLinkedLists[i].list(i);
        }
    }


    //根据输入的id,查找雇员
    public void findEmpById(int id) {
        int i = hashFun(id);
        Emp empById = empLinkedLists[i].findEmpById(id);
        if (empById != null) {//找到
            System.out.printf("在第%d条链表中找到 雇员 id = %d\n", (i + 1), id);
        } else {
            System.out.println("在哈希表中，没有找到该雇员~");
        }
    }

    public int hashFun(int id) {
        return id % size;
    }
}

class Emp {
    public int id;
    public String name;
    public Emp next; //next 默认为 null

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }


}


//创建EmpLinkedList ,表示链表
class EmpLinkedList {
    //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
    private Emp head; //默认null

    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp) {
        if (head == null) {
            head = emp;
            return;
        }
        Emp cur = head;
        while (true) {
            if (cur.next == null) {
                break;
            }
            cur = cur.next;
        }
        cur.next = emp;
    }

    //遍历链表的雇员信息
    public void list(int no) {
        if (head == null) {
            //说明链表为空
            System.out.println("第 " + (no + 1) + " 链表为空");
            return;
        }
        Emp curEmp = head;
        while (true) {
            System.out.printf(" => id=%d name=%s\t", curEmp.id, curEmp.name);
            if (curEmp.next == null) {
                break;
            }
            curEmp = curEmp.next;
        }
        System.out.println();
    }

    //根据id查找雇员
    //如果查找到，就返回Emp, 如果没有找到，就返回null
    public Emp findEmpById(int id) {
        //判断链表是否为空
        if (head == null) {
            System.out.println("链表为空");
            return null;
        }
        Emp cur = head;
        while (true) {
            if (cur.id == id) {
                return cur;
            }
            if (cur.next == null) {
                cur = null;
                break;
            }
            cur = cur.next;
        }
        return cur;
    }
}

package com.study.tree;

/**
 * @author HULU
 * @version 创建时间：2020/8/18 11:52
 */
public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {
        //测试一把中序线索二叉树的功能
        DataNode root = new DataNode(1, "tom");
        DataNode node2 = new DataNode(3, "jack");
        DataNode node3 = new DataNode(6, "smith");
        DataNode node4 = new DataNode(8, "mary");
        DataNode node5 = new DataNode(10, "king");
        DataNode node6 = new DataNode(14, "dim");

        //二叉树，后面我们要递归创建, 现在简单处理使用手动创建
        root.setLeft(node2);
        root.setRight(node3);
        node2.setLeft(node4);
        node2.setRight(node5);
        node3.setLeft(node6);

        //测试中序线索化
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree();
        threadedBinaryTree.setRoot(root);
        threadedBinaryTree.threadedNodes();

        //测试: 以10号节点测试
        DataNode leftNode = node5.getLeft();
        DataNode rightNode = node5.getRight();
        System.out.println("10号结点的前驱结点是 ="  + leftNode); //3
        System.out.println("10号结点的后继结点是="  + rightNode); //1

        threadedBinaryTree.threadedList();
    }



}
class ThreadedBinaryTree {

    private DataNode root;

    //为了实现线索化，需要创建要给指向当前结点的前驱结点的指针
    //在递归进行线索化时，pre 总是保留前一个结点
    private DataNode pre=null;


    public void setRoot(DataNode root) {
        this.root = root;
    }

    //遍历线索化二叉树的方法
    public void threadedList() {
        DataNode node = root;
        while (node!=null){

            while (node.getLeftType() ==0){
                node = node.getLeft();
            }
            System.out.println(node);
            while (node.getRightType() ==1){
                node =node.getRight();
                System.out.println(node);
            }
            node= node.getRight();

        }
    }

    //重载一把threadedNodes方法
    public void threadedNodes() {
        this.threadedNodes(root);
    }

    //编写对二叉树进行中序线索化的方法
    /**
     *
     * @param node 就是当前需要线索化的结点
     */
    public void threadedNodes(DataNode node) {
        //如果node==null, 不能线索化
      if (node ==null){
          return;
      }
        //(一)先线索化左子树
        threadedNodes(node.getLeft());

        //(二)线索化当前结点[有难度]

        //处理当前结点的前驱结点
        //以8结点来理解
        //8结点的.left = null , 8结点的.leftType = 1
        if(node.getLeft() == null) {
            //让当前结点的左指针指向前驱结点
            node.setLeft(pre);
            //修改当前结点的左指针的类型,指向前驱结点
            node.setLeftType(1);
        }
        //处理后继结点
        if (pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setRightType(1);
        }

        //!!! 每处理一个结点后，让当前结点是下一个结点的前驱结点
        pre = node;

        //(三)在线索化右子树
        threadedNodes(node.getRight());

    }
}

class DataNode {
    private int no;
    private String name;
    private DataNode left; //默认null
    private DataNode right; //默认null

    //说明
    //1. 如果leftType == 0 表示指向的是左子树, 如果 1 则表示指向前驱结点
    //2. 如果rightType == 0 表示指向是右子树, 如果 1表示指向后继结点
    private int leftType;
    private int rightType;

    public DataNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataNode getLeft() {
        return left;
    }

    public void setLeft(DataNode left) {
        this.left = left;
    }

    public DataNode getRight() {
        return right;
    }

    public void setRight(DataNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "DataNode [no=" + no + ", name=" + name + "]";
    }

}
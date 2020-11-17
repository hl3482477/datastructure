package com.study.merge;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HULU
 * @version 创建时间：2020/7/16 17:45
 */
public class Test {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();

            Student a1 = new Student("aa", 1);
            list.add(a1);
        Student a2 = new Student("b", 2);
        list.add(a2);
        Student a3 = new Student("b", 2);
        list.add(a3);
        Student e3 = new Student("e", 2);
        list.add(e3);
        Student c2 = new Student("c", 2);
        list.add(c2);
        Student c3 = new Student("c", 2);
        list.add(c3);

        Student d3 = new Student("d", 2);
        list.add(d3);

        Test test = new Test();
        List<Student> merge = test.merge(list);
        for (int i = 0; i < merge.size(); i++) {
            System.out.println(merge.get(i).toString());
        }
    }

    public List<Student> merge(List<Student> students) {

        List<Student> viewList = new ArrayList<>();
        for (Student student : students) {
            if (viewList.isEmpty()){
                viewList.add(student);
            }else {
                if (viewList.get(viewList.size()-1).getName().equals(student.getName())){
                    int score = student.getScore();
                    student.setScore(score+viewList.get(viewList.size()-1).getScore());
                    viewList.remove(viewList.size()-1);
                    viewList.add(student);
                }else {
                    viewList.add(student);
                }
            }
        }
        return viewList;
    }
}

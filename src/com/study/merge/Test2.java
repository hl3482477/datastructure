package com.study.merge;

import java.util.HashSet;
import java.util.Set;

/**
 * @author HULU
 * @version 创建时间：2020/8/5 15:25
 */
public class Test2 {

    public static void main(String[] args) {
        String[] s = {"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
        int i = numUniqueEmails(s);
        System.out.println(i);
    }

    public static int numUniqueEmails(String[] emails) {

        Set set = new HashSet();
        for (String s : emails) {
            String[] splits = s.split("@");
            String local = splits[0];
            String rest = splits[1];
            if (local.contains("+")) {
                int index = local.indexOf('+');
                local = local.substring(0, index);
            }
            if (local.contains(".")){
                local = local.replaceAll("\\.", "");
            }
            set.add(local +"@"+ rest);
        }
        return set.size();
    }
}

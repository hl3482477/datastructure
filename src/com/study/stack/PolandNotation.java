package com.study.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author HULU
 * @version 创建时间：2020/6/24 13:41
 */
public class PolandNotation {
    public static void main(String[] args) {

        String expression = "1+((2+3)*4)-5";//注意表达式
        List<String> infixExpressionList = toInfixExpressionList(expression);
        System.out.println("中缀表达式对应的List=" + infixExpressionList); // ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]
        List<String> suffixExpreesionList = parseSuffixExpreesionList(infixExpressionList);
        System.out.println("后缀表达式对应的List" + suffixExpreesionList); //ArrayList [1,2,3,+,4,*,+,5,–]

        System.out.printf("expression=%d", calculate(suffixExpreesionList)); // ?

      /*  String suffixExpression = "4 5 * 8 - 60 + 8 2 / +"; // 76
        List<String> listString = getListString(suffixExpression);
        int calculate = calculate(listString);
        System.out.println(calculate);*/
       /* char c = "1+11*".charAt(0);
        System.out.println(c >= 48 & c <= 57);*/
    }


    //即 ArrayList [1,+,(,(,2,+,3,),*,4,),-,5]  =》 ArrayList [1,2,3,+,4,*,+,5,–]
    //方法：将得到的中缀表达式对应的List => 后缀表达式对应的List
    public static List<String> parseSuffixExpreesionList(List<String> ls) {
        //定义两个栈
        Stack<String> s1 = new Stack<String>(); // 符号栈
        //说明：因为s2 这个栈，在整个转换过程中，没有pop操作，而且后面我们还需要逆序输出
        //因此比较麻烦，这里我们就不用 Stack<String> 直接使用 List<String> s2
        //Stack<String> s2 = new Stack<String>(); // 储存中间结果的栈s2
        List<String> s2 = new ArrayList<String>(); // 储存中间结果的Lists2

        for (String l : ls) {
            if (l.matches("\\d+")) {
                //如果是数则直接入
                s2.add(l);
            } else if (l.equals("(")) {
                //如果是左括号则直接入符号栈
                s1.add(l);
            } else if (l.equals(")")) {
                //如果是右括号“)”，则依次弹出s1栈顶的运算符，并压入s2，直到遇到左括号为止，此时将这一对括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();//（弹出
            }else {
                //是运算符时
                //当item的优先级小于等于s1栈顶运算符, 将s1栈顶的运算符弹出并加入到s2中，再次转到(4.1)与s1中新的栈顶运算符相比较
                while(s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(l) ) {
                    s2.add(s1.pop());
                }
                //还需要将item压入栈
                s1.push(l);
            }
        }
        //将s1中剩余的运算符依次弹出并加入s2
        while(s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //方法：将 中缀表达式转成对应的List
    //  s="1+((2+3)×4)-5";
    public static List<String> toInfixExpressionList(String s) {
        List<String> strings = new ArrayList<>();
        int i = 0;
        String str;
        char c;

        do {
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                //是运算符
                strings.add(String.valueOf(c));
                i++;
            } else { //如果是一个数，需要考虑多位数
                str = "";
                while (i < s.length() && (c = s.charAt(i)) >= 48 && (c = s.charAt(i)) <= 57) {
                    str += c;
                    i++;
                }
                strings.add(str);
            }

        } while (i < s.length());
        return strings;
    }


    public static List<String> getListString(String ex) {
        String[] split = ex.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : split) {
            list.add(s);
        }
        return list;
    }

    public static int calculate(List<String> ls) {
        Stack<String> stack = new Stack<>();
        for (String l : ls) {
            if (l.matches("\\d+")) {
                stack.add(l);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int rs = 0;
                if (l.equals("+")) {
                    rs = num1 + num2;
                } else if (l.equals("-")) {
                    rs = num1 - num2;
                } else if (l.equals("*")) {
                    rs = num1 * num2;
                } else if (l.equals("/")) {
                    rs = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res 入栈
                stack.push("" + rs);
            }
        }
        //最后留在stack中的数据是运算结果
        return Integer.parseInt(stack.pop());
    }
}


//编写一个类 Operation 可以返回一个运算符 对应的优先级
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //写一个方法，返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                System.out.println("不存在该运算符" + operation);
                break;
        }
        return result;
    }

}

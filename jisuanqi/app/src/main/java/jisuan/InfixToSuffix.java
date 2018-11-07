package jisuan;

import java.util.ArrayList;
import java.util.Stack;

public class InfixToSuffix
{
    /**
     * 遍历集合，是数字则入栈，碰到操作符，将数字出站，判断操作符，并执行相应的操作
     * @param suffix
     * @return
     */
    public static double getResult(ArrayList<String> suffix)
    {
        Stack<String> stack = new Stack<String>();
        for(String element_suffix:suffix)
        {
            //如果是数字，入栈
            if(Character.isDigit(element_suffix.charAt(0)))
            {
                stack.push(element_suffix);
            }else{
                //如果遇到运算符，取出元素，并判断操作符，执行相应的计算
                //自动拆箱：将包装类转换成基本类型
                //自动装箱：将基本类型转换成包装类
                double ANumber = Double.valueOf(stack.pop());//自动拆箱，取出第一个元素
                double BNumber = Double.valueOf(stack.pop());//自动拆箱，取出第二个元素
                double result = 0;
                switch (element_suffix) {
                    case "+":
                        result = ANumber+BNumber;
                        break;
                    case "-":
                        result = ANumber-BNumber;
                        break;
                    case "*":
                        result = ANumber*BNumber;
                        break;
                    case "/":
                        result = ANumber/BNumber;
                        break;
                    default:
                        break;
                }
                stack.push(result+"");
            }
        }
        return Double.valueOf(stack.pop());
    }
    /**
     * 将字符串转成集合
     * @param str 待转的字符串
     * @return
     */
    public static ArrayList<String> getArrayList(String str)
    {
        ArrayList<String> stringList = new ArrayList<String>();//用于存储字符串集合
        for(char chs:str.toCharArray())
        {
            stringList.add(chs+"");
        }
        System.out.println("将字符串存入集合："+stringList);
        return stringList;
    }
    /**
     * 比较当前运算符和栈顶运算符的优先级
     * @param stackPeek 栈顶元素
     * @param current 当前元素
     * @return
     */
    public static boolean getPriority(String stackPeek,String current)
    {
        if(stackPeek.matches("[\\*\\/]") && current.matches("[\\+\\-\\*\\/]"))
        {
            return true;
        }else if(stackPeek.matches("[\\+\\-]") && current.matches("\\+\\-"))
        {
            return true;
        }
        return false;
    }
    /**
     * 获得后缀表达式
     * @param infix 传入的中缀表达式的集合
     * @return
     */
    public static ArrayList<String> getSuffix(ArrayList<String> infix)
    {
        ArrayList<String> suffix = new ArrayList<String>();//用于存储最后的后缀式
        Stack<String> operator = new Stack<String>();//用于比较运算符优先级
        //第一步：分离数字和运算符
        for(String chs:infix)
            if(Character.isDigit(chs.charAt(0)))
            {//如果是数字，加入集合
                suffix.add(chs);
            }else{
                //如果不是数字，分离括号和运算符
                switch (chs.charAt(0)) {
                    //左括号直接入栈
                    case '(':
                        operator.push(chs);
                        break;
                    //右括号，出栈，直到左括号出栈
                    case ')':
                        while(!"(".equals(operator.peek()))
                            suffix.add(operator.pop());
                        operator.pop();//左括号出栈
                        break;
                    default:
                        //如果是运算符，先比较优先级，如果当前元素的优先级低于栈顶元素，则栈顶元素出栈，当前元素出栈
                        //原则是保证栈顶元素的优先级最高
                        //如果栈顶元素优先级高，返回true,栈顶元素出栈，直到存在元素优先级低于当前元素
                        while(!operator.isEmpty() && getPriority(operator.peek(),chs))
                            suffix.add(operator.pop());
                        operator.push(chs);//优先级高的栈顶元素出栈后，加入优先级更低的元素
                        break;
                }
            }
        //判断栈中是否还有元素，有的话，取出
        while(!operator.isEmpty())
            suffix.add(operator.pop());
        System.out.println("中缀式是:"+suffix);
        return suffix;
    }
}
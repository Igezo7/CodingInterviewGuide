package main.java.algo;

import java.util.Stack;

/**
 * Created by igezo on 2018/6/6.
 */

/**
 * 设计一个具有getMin的栈，
 * 此算法Min栈在压入的时候节省空间弹出稍费时间，还有一种算法压入的时候不节省空间但弹出节约时间
 */
public class Algo1 {
    private Stack<Integer> stackDate;
    private Stack<Integer> stackMin;

    public Algo1(){
        this.stackDate = new Stack<Integer>();
        this.stackMin = new Stack<Integer>();
    }

    public void push(int num){
        stackDate.push(num);
        if(stackMin.isEmpty()||stackMin.peek()>=num){
            stackMin.push(num);
        }
//        if (num<=stackMin.peek()){
//            stackMin.push(num);
//        }
    }

    public int pop(){
        int num = 0 ;
        if (stackDate.isEmpty()){
            throw  new RuntimeException("stack is empty");
        }
        num = stackDate.pop();
        if (num<=stackMin.peek()){
            stackMin.pop();
        }
        return num;
    }

    public int getMin(){
        if (stackMin.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return stackMin.peek();
    }

    public static void main(String[] args) {
        Algo1 stack1 = new Algo1();
        stack1.push(3);
        stack1.push(4);
        stack1.push(5);
        stack1.push(1);
        stack1.push(2);
        stack1.push(1);
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
        System.out.println(stack1.pop());
        System.out.println(stack1.getMin());
    }

}

package main.java.algo;

/**
 * Created by igezo on 2018/6/6.
 */

import java.util.Stack;

/**
 * 用递归函数和栈操作逆序一个栈
 */
public class Alog3 {
//    private Stack<Integer> stack;
//
//    public Alog3(){
//        this.stack = new Stack<Integer>();
//    }
//
    public int getLastNum(Stack<Integer> tmpStack){
        if (tmpStack.isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        int result = tmpStack.pop();
        if (tmpStack.isEmpty()){
            return result;
        }else {
            int last = getLastNum(tmpStack);
            tmpStack.push(result);
            return last;
        }
    }

    public void reverse(Stack<Integer> tmpStack){
        if (tmpStack.isEmpty()){
            return;
        }
        int last = getLastNum(tmpStack);
        reverse(tmpStack);
        tmpStack.push(last);
    }

    public static void main(String[] args) {
        Alog3 stack = new Alog3();
        Stack<Integer> nStack = new Stack<Integer>();
        nStack.push(1);
        nStack.push(2);
        nStack.push(3);
        nStack.push(4);
        stack.reverse(nStack);
        System.out.println(nStack.toString());
    }
}

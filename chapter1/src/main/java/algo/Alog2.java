package main.java.algo;

/**
 * Created by igezo on 2018/6/6.
 */

import java.util.Stack;

/**
 * 用两个栈实现队列
 */
public class Alog2 {
    private Stack<Integer> stackPush;
    private Stack<Integer> stackPop;

    public Alog2(){
        this.stackPush = new Stack<Integer>();
        this.stackPop = new Stack<Integer>();
    }

    public void add(int num){
        stackPush.push(num);
    }

    public int peek(){
        if (stackPop.isEmpty()){
            if (stackPush.isEmpty()){
                throw new RuntimeException("stack is empty");
            }else{
                while (!stackPop.isEmpty()){
                    stackPop.push(stackPush.pop());
                }
                return stackPop.peek();
            }
        }else {
            return stackPop.peek();
        }
    }

    public int poll(){
        if (stackPop.isEmpty()&&stackPush.isEmpty()){
            throw new RuntimeException("stack is empty");
        }else if(stackPop.isEmpty()){
            while (!stackPush.isEmpty()){
                stackPop.push(stackPush.pop());
            }
        }
        return stackPop.pop();
    }

    public static void main(String[] args) {
        Alog2 stack = new Alog2();
        stack.add(1);
        stack.add(2);
        stack.add(3);
        stack.add(4);
        stack.add(5);
        System.out.println(stack.poll());
        System.out.println(stack.peek());
    }

}

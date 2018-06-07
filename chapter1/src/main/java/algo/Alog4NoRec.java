package main.java.algo;

/**
 * Created by igezo on 2018/6/7.
 */

import java.util.Stack;

/**
 * 汉诺塔问题，用非递归的方法，用stack模拟
 * 总共可以模拟出四个步骤：左→中，中←左，中→右，右←中
 * 两个特点：
 * 1、第一个数肯定是从左到中
 * 2、每次移动只能满足四个步骤中的一个
 */
public class Alog4NoRec {

    public enum Action{
        no,LToM,MToL,MToR,RToM
    }


    public int getStep(int num){
        Stack<Integer> left =  new Stack<Integer>();
        Stack<Integer> mid = new Stack<Integer>();
        Stack<Integer> right = new Stack<Integer>();
        left.push(Integer.MAX_VALUE);
        mid.push(Integer.MAX_VALUE);
        right.push(Integer.MAX_VALUE);
        int step = 0;
        for (int i = num;i>0;i--){
            left.push(i);
        }
        Action[] action = {Action.no};
        while (right.size()!=num+1){
            step += move(action,Action.LToM,Action.MToL,left,mid);
            step += move(action,Action.MToL,Action.LToM,mid,left);
            step += move(action,Action.MToR,Action.RToM,mid,right);
            step += move(action,Action.RToM,Action.MToR,right,mid);
        }
        return step;
    }

    public static int move(Action[] action,Action preAct,Action nowAction,Stack<Integer> from,Stack<Integer> to){
        if (action[0]!=preAct&&from.peek()<to.peek()){
            to.push(from.pop());
            action[0] = nowAction;
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        Alog4NoRec alo = new Alog4NoRec();
        int m = alo.getStep(1);
        System.out.println(m);
        int n = alo.getStep(2);
        System.out.println(n);
        System.out.println(alo.getStep(3));

    }


}

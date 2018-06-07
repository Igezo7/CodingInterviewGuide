package main.java.algo;

/**
 * Created by igezo on 2018/6/7.
 */

/**
 * 汉诺塔问题用递归函数解决
 * 分为两种
 * 如果从左到中（从中到左，从中到右，从右到中同理）分为三步：1、n-1移动到右  2、n移动到中   3、n-1移动到中
 * 如果从左到右：1、n-1移动到右  2、n移动到中   3、n-1移动到左  4、n移动到右  4、n-1移动到右
 */
public class Alog4Rec {
    public int hanoiProble(int num,String left,String mid,String right,String from,String to){
        if (num<1) {
            return 0;
        }
        return getStep(num,left,mid,right,from,to);
    }

    public int getStep(int num,String left,String mid,String right,String from,String to){
        if (num==1){
            if (from.equals(mid)||to.equals(mid))
                return 1;
            else
                return 2;
        }
        if (from.equals(mid)||to.equals(mid)){
            String another = (from.equals(mid)||to.equals(mid))?right:left;
            int step1 = getStep(num-1,left,mid,right,from,another);
            int step2 = 1;
            int step3 = getStep(num,left,mid,right,right,to);
            return step1+step2+step3;
        }else {
            int step1 = getStep(num-1,left,mid,right,from,to);
            int step2 = 1;
            int step3 = getStep(num-1,left,mid,right,to,from);
            int step4 = 1;
            int step5 = getStep(num-1,left,mid,right,from,to);
            return step1+step2+step3+step4+step5;
        }
    }

    public static void main(String[] args) {
        Alog4Rec alo = new Alog4Rec();
        System.out.println(alo.hanoiProble(1,"left","mid","right","left","right"));
        System.out.println(alo.hanoiProble(2,"left","mid","right","left","right"));
        System.out.println(alo.hanoiProble(3,"left","mid","right","left","right"));
    }
}

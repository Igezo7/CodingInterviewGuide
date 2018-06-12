package main.java.algo;

/**
 * Created by igezo on 2018/6/12.
 */

import java.util.LinkedList;

/**
 * 生成窗口最大值数组，一个整型数组arr和大小为w的窗口，从左滑到右，生成一个n-w+1的最大值窗口
 */
public class Alog5 {

    public int[] getMaxWindow(int[] arr,int m){
        if (arr==null||arr.length<m||m<1){
            return null;
        }
        LinkedList<Integer> max = new LinkedList<Integer>();
        int len = arr.length;
        int[] res = new int[len-m+1];
        int index = 0;
        for (int i =0;i<len;i++){
            while (!max.isEmpty()&&max.peekLast()<=arr[i]){
                max.pollLast();
            }
            max.addLast(i);
            if (max.peekFirst()==i-m){
                max.pollFirst();
            }
            if (i>=m-1){
                res[index++] = arr[max.peekFirst()];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] m = {2,5,4,8,6};
//        m = new int[5];
        Alog5 alo = new Alog5();
        int[] n = new int[4];
        n = alo.getMaxWindow(m,2);
        for (int i:n){
            System.out.println(i);
        }

    }

}

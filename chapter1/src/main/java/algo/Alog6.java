package main.java.algo;

/**
 * Created by igezo on 2018/6/12.
 */

import java.util.LinkedList;

/**
 * 最大值减去最小值小于或等于num的子数组数量
 * 找到一个临界的区间arr[i]~arr[j]，使得arr[i-1]~arr[j]或arr[i]~arr[j+1]都不满足条件。
 * i~j区间内的子数组必满足条件
 */
public class Alog6 {

    public int getChildrenNum(int[] arr, int n){
        if (arr==null||arr.length==1){
            return 0;
        }
        int res = 0;
        LinkedList<Integer> max = new LinkedList<Integer>();
        LinkedList<Integer> min = new LinkedList<Integer>();
        int i = 0;
        int j = 0;//这里跟下面的j=i比较
        int count = 0;
        while (i<arr.length){
//            int j = i;  找到临界的区间后，j不用从头开始，区间内的数组都满足条件
            while ( j< arr.length){
//                System.out.println("cout:"+count++);
                while (!max.isEmpty()&&arr[max.peekLast()]<=arr[j]){
                    max.pollLast();
                }
                max.addLast(j);
                while (!min.isEmpty()&&arr[min.peekLast()]>=arr[j]){
                    min.pollLast();
                }
                min.addLast(j);
                if (arr[max.peekFirst()]-arr[min.peekFirst()]>n){
//                    System.out.println(j-i);
                    break;
                }
                j++;
            }
            //两个if很关键
            if (max.peekFirst()==i){
                max.pollFirst();
            }
            if (min.peekFirst()==i){
                min.pollFirst();
            }
            res += j-i;
//            System.out.println((j-i));
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {1,6,4,2,7};
        Alog6 alo = new Alog6();
        int res;
        res = alo.getChildrenNum(arr,3);
        System.out.println(res);
    }

}

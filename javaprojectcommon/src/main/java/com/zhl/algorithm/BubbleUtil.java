package com.zhl.algorithm;

/**
 * 冒泡排序
 * Created by zhl on 18/3/20 下午4:15.
 */
public class BubbleUtil {

    public static void main(String[] args) {
        int[] array = {12,34,1,42,45};
        int[] bubbleArray = bubbleSort(array);
        for(int a:bubbleArray){
            System.out.println(a);
        }
    }


    public static int[] bubbleSort(int[] array){
        if(array.length == 0){
            return array;
        }
        for(int i=0;i<array.length;i++){
            for(int j=0;j<array.length - 1 - i; j++){
                if(array[j+1] < array[j]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }
}

package com.zhl.algorithm;

/**
 * Created by zhl on 19/1/8 下午8:54.
 */
public class stack01 {

    //使用数组存储堆中的数据
    private int[] array = {33,17,21,16,13,15,9,5,6,7,8,1,2};
    private int n;

    /**
     * 建立最大堆
     */
    private int[] buildMaxHeap(int[] array){
        for(int i=(array.length);i<1;i++) {

        }
        return array;
    }

    //调整堆
    private void adjustDownToUp(int[] array, int k, int length){
        int temp = array[k];
        for(int i=2*k+1; i<length-1; i=2*i+1){

        }
    }

}

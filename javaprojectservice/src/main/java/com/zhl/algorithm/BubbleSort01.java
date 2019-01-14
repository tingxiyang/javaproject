package com.zhl.algorithm;

import java.util.Arrays;

/**
 * Created by zhl on 19/1/9 上午9:48.
 * 冒泡排序
 * 时间复杂度：O(n*n)
 * 空间复杂度：O(1)
 * 冒泡排序法 口诀：
 *      外层循环 0到n-1      //控制比较轮数   n 表示元素的个数
 *      内层循环 0到n-i-1     //控制每一轮比较次数
 *      两两比较做交换
 */
public class BubbleSort01 implements IArraySort{

    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        //对arr进行copy,不改变参数内容ReentrantLockReentrantLock
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=0; i<arr.length-1;i++) {
            //设定一个标记，若为true, 则表示此次循环没有进行交换，也就是待排序已经有序，排序已经完成
            boolean flag = true;

            for (int j = 0; j < arr.length-1-i; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                    flag = false;
                }
            }
            if(flag) {
                break;
            }
        }
        return arr;
    }



}

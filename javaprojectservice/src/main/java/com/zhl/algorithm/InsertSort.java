package com.zhl.algorithm;

import java.util.Arrays;

/**
 * Created by zhl on 19/1/14 上午9:24.
 * 插入排序
 */
public class InsertSort implements IArraySort {
    @Override
    public int[] sort(int[] sourceArray) throws Exception {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for(int i=1; i < arr.length; i++) {
            //记录要插入的值
            int tmp = arr[i];
            //从已经排序的序列最右边的开始比较，找到比其小的书
            int j=i;
            while (j > 0 && tmp < arr[j - 1]) {
                arr[j] = arr[j - 1];
                j--;
            }
            // 存在比其小的数，插入
            if(j != i) {
                arr[j] = tmp;
            }
        }
        return arr;
    }
}

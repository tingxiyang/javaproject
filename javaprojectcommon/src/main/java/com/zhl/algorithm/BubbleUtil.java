package com.zhl.algorithm;

/**
 * 冒泡排序
 * 时间复杂度： O(n^2)
 * 空间复杂度：
 *
 * 空间复杂度就是在交换元素时那个临时变量所占的内存空间；
 最优的空间复杂度就是开始元素顺序已经排好了，则空间复杂度为：0；
 最差的空间复杂度就是开始元素逆序排序了，则空间复杂度为：O(n)；
 平均的空间复杂度为：O(1)；
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

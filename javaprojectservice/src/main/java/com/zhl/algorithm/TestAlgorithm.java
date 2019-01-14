package com.zhl.algorithm;

/**
 * Created by zhl on 19/1/9 上午10:00.
 */
public class TestAlgorithm {

    public static void main(String[] args) throws Exception {
//        IArraySort arraySort = new BubbleSort01();
        IArraySort arraySort = new SelectionSort();
        int[] sourceArray = {2, 4, 6, 1, 2, 57, 43, 13, 44, 14, 0, 98};
                        //   0  1  2  3  4  5    6   7   8   9  10  11

        int[] bubbleArr = arraySort.sort(sourceArray);
        for(int b:bubbleArr){
            System.out.print(b+" ");
        }



    }

}

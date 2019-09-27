package com.github.nicejing.data.sort;

import java.util.Arrays;

/**
 * 选择排序
 * @author Jing Zhi Bao
 */
public class SelectSort {

    public static void main(String[] args) {

        int[] arr = {101, 45 , 55, 1};
        selectSort(arr);

    }

    public static void selectSort(int[] arr){

        for(int i =0; i < arr.length -1; i++){
            int minIndex = i;
            int min = arr[i];

            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }

            System.out.println(Arrays.toString(arr));


        }


    }
}

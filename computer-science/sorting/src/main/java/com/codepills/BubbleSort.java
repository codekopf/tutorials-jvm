package com.codepills;

public class BubbleSort {

    /**
     * Sort elements of array in ascending order
     * @param arr - array of lent
     * @return sorted array
     */
    public int[] sortWithDoubleFor(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        for(int i = 0; i < arr.length - 1; i++) {
            for(int j = 0; j < arr.length - 1; j++) {
                if(arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        return arr;
    }

    /**
     * Sort elements of array in ascending order
     * @param arr - array of lent
     * @return sorted array
     */
    public int[] sortWithWhile(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        boolean notSorted = true;
        while(notSorted) {
            notSorted = false;
            for(int i = 0; i < arr.length - 1; i++) {
                if(arr[i] > arr[i+1]) {
                    notSorted = true;
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }
        return arr;
    }
}

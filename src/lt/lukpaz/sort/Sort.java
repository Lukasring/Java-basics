package lt.lukpaz.sort;

import java.util.Arrays;

public class Sort {
    public static void main (String[] args) {
//        int[] data = {5,7,4,0,8,9,-5, 16, 0};
        int[] data = {3,8,2,66,11,-10,-5,11,42,12,15,0,0};
        System.out.print("Original array: ");
        printArray(data);
        int[] sortedData = simpleSort(data);
        System.out.print("Sorted array: ");
        printArray(sortedData);
        System.out.print("Bubble sort array: ");
        printArray(bubbleSort(data));
        System.out.print("Merge sort array: ");
        printArray(mergeSort(data));

    }

    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.print("\n");
    }

    public static int[] simpleSort(int[] data) {
        int[] arr = Arrays.copyOf(data, data.length);
        // selection sort lygtai
        for(int i = 0; i<arr.length; i++) {
            for (int j = i+1; j<arr.length; j++) {
             if (arr[j] > arr[i]) {
                 int temp = arr[j];
                 arr[j] = arr[i];
                 arr[i] = temp;
             }
            }
        }
        return arr;
    }

    public static int[] bubbleSort(int[] data) {
        int[] arr = Arrays.copyOf(data, data.length);
        for(int i =0; i<arr.length; i++){
            boolean swapped = false;
            for (int j = 1; j < arr.length; j++) {
                if (arr[j] > arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return arr;
    }

    public static int[] mergeSort(int[] data) {
        int[] arr = Arrays.copyOf(data, data.length);
        if(arr.length == 1) {
            return arr;
        }
        // split array
        int middleIndex = arr.length/2;
        int[] leftArray = Arrays.copyOfRange(arr, 0,middleIndex);
        int[] rightArray = Arrays.copyOfRange(arr, middleIndex, arr.length);
        int[] sortedLeftArr = mergeSort(leftArray);
        int[] sortedRightArr = mergeSort(rightArray);

        return mergeArrays(sortedLeftArr, sortedRightArr);
    }

    public static int[] mergeArrays(int[] leftArr, int[] rightArr) {
        int mergedArrayLength = leftArr.length + rightArr.length;
        int[] mergedArray = new int[mergedArrayLength];
        int leftIndex = 0;
        int rightIndex = 0;
        int mergedArrayIndex = 0;

        // merge until one of the arrays is empty
        for(int i=0; i<mergedArrayLength; i++) {
            mergedArrayIndex = i; // ties kuriuo elementu nutraukiam cikla
            if (leftIndex == leftArr.length || rightIndex == rightArr.length) {
                break;
            }
            if(leftArr[leftIndex] >= rightArr[rightIndex]) {
                mergedArray[i] = leftArr[leftIndex];
//                leftIndex = leftIndex == leftArr.length - 1 ? leftIndex : ++leftIndex;
                leftIndex++;
            } else {
                mergedArray[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }
        // add remaining elements to merged array

        if(leftIndex != leftArr.length) {
            for(int i = mergedArrayIndex; i<mergedArrayLength; i++) {
                mergedArray[i] = leftArr[leftIndex];
                leftIndex++;
            }
        } else if (rightIndex != rightArr.length) {
            for(int i = mergedArrayIndex; i<mergedArrayLength; i++) {
                mergedArray[i] = rightArr[rightIndex];
                rightIndex++;
            }
        }


        return mergedArray;
    }

    public static String[] sortAlphabetically(String[] words) {
        String[] stringArray = Arrays.copyOf(words, words.length);
        for(int i=0; i<stringArray.length; i++) {
            for(int j=i+1; j<stringArray.length; j++) {
                if (stringArray[i].compareTo(stringArray[j])>0) {
                    String temp = stringArray[i];
                    stringArray[i] = stringArray[j];
                    stringArray[j] = temp;
                }
            }
        }

        return stringArray;
    }
}

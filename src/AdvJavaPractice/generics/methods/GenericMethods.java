package AdvJavaPractice.generics.methods;

import java.util.Arrays;

public class GenericMethods {
    public static void main(String[] args) {

        String[] stdList = {"Gulsum", "halil", "Erkan"};
        printArray(stdList);
        Character[] char1 = {'G', 'H', 'E'};
        printArray(char1);
        System.out.println(Arrays.toString(orderArr(stdList)));
        System.out.println(Arrays.toString(orderArr(char1)));

    }
/*
    public static void printArray(String[] arr) {
        for (String s : arr) {
            System.out.println(s);
        }
    }
*/

    public static <T> void printArray(T[] arr) {
        for (T s : arr) {
            System.out.println(s);
        }
    }

    static <T extends Comparable<T>> T[] orderArr(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i].compareTo(arr[j]) > 0) { // i j'den buyukse 1, esitse 0, kucukse -1 doner
                    T temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        return arr;
    }
}
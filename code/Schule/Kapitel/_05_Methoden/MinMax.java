package Schule.Kapitel._05_Methoden;

import java.util.Random;

public class MinMax {

    static Random random = new Random();
    public static void main(String[] args) {
        int[] numberArray = setRandIntArray(-100, 100, 10); //arrayLength ist dynamisch / ohne Probleme veränderbar
        printIntArray(numberArray, numberArray.length);

        int[][] minAndMax = getMinAndMax(numberArray, numberArray.length);
        System.out.println();
        System.out.println("Minimum: "+minAndMax[0][0]+", Maximum: "+minAndMax[1][0]);
    }



    public static int[] setRandIntArray(int numberRangeFrom, int numberRangeTo, int arrayLength){
        int[] numberArray = new int[arrayLength];

        for (int i=0; i<arrayLength; i++){
            int randInt = random.nextInt(numberRangeFrom, numberRangeTo+1);
            numberArray[i] = randInt;
        }
        return numberArray;
    }


    public static void printIntArray(int[] printedNumberArray, int arrayLength){
        System.out.print("Array: ");
        for (int i=0; i<printedNumberArray.length; i++){
            if (i==arrayLength-1){
                System.out.print(printedNumberArray[i]);
            }
            else {
                System.out.print(printedNumberArray[i]+", ");
            }
        }
    }


    public static int[][] getMinAndMax(int[] numberArray, int arrayLength){
        int[][] minAndMax = new int[2][1];

        for (int i=0; i<arrayLength; i++){
            int currentNumber = numberArray[i];
            if (currentNumber >= minAndMax[0][0]) {
                minAndMax[0][0] = currentNumber;
            }
            else if (currentNumber <= minAndMax[1][0]){
                minAndMax[1][0] = currentNumber;
            }
        }
        return minAndMax;
    }
}

package Schule.Kapitel._08_Sortierverfahren._01_Benchmark;

import java.util.Random;

public class SortSystem {

    int[] array;

    public SortSystem(int size){
        array = new int[size];
    }

    public void printArray(){
        for (int i : array) {
            System.out.print("["+i+"] ");
        }
        System.out.println();
    }

    public void fillArray() {
        Random random = new Random();
        for(int i=0; i<array.length; i++){
            array[i] = random.nextInt(100000);
        }
        this.shuffle();
    }

    public void startSort(){};

    public void shuffle(){
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            int randomInd = rand.nextInt(array.length);     //randInd   = 3
            int temp = array[i];                            //temp      = array[0] = 5
            array[i] = array[randomInd];                    //array[0]  = array[3] = 20
            array[randomInd] = temp;                        //array[3]  = 5
        }
    }

}

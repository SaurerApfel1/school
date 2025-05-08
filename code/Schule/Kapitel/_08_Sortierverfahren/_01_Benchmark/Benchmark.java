package Schule.Kapitel._08_Sortierverfahren._01_Benchmark;

public class Benchmark {
    public static void main(String[] args) {
        int size = 10000;

        
        // Bubble Sort
        SortSystem bubbleSort = new BubbleSort(size);
        bubbleSort.fillArray();
        long startimeBS = System.currentTimeMillis();
        bubbleSort.startSort();
        long endtimeBS = System.currentTimeMillis();
        long elapsedTimeBS = endtimeBS - startimeBS; 


        //Selection Sort
        SortSystem selectionSort = new SelectionSort(size);
        selectionSort.fillArray();
        long startTimeSS = System.currentTimeMillis();
        selectionSort.startSort();
        long endTimeSS = System.currentTimeMillis();
        long elapsedTimeSS = endTimeSS - startTimeSS;


        System.out.println("---Array Size : "+size+"---");
        System.out.println("BubbleSort Time: " + elapsedTimeBS + " ms");
        System.out.println("SelectionSort Time: "+elapsedTimeSS+ " ms");


    }
}

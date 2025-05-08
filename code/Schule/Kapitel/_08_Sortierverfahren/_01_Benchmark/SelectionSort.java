package Schule.Kapitel._08_Sortierverfahren._01_Benchmark;

public class SelectionSort extends SortSystem{

    public SelectionSort(int size) {
        super(size);
    }

    @Override
    public void startSort() {
        for (int i = 0; i<array.length-1; i++){
            int minPos = i;
            for (int j = i + 1; j<array.length; j++) {
                if (array[j] < array[minPos]) {
                    minPos = j;
                }
            }
            if (minPos != i) {
                int temp = array[i];
                array[i] = array[minPos];
                array[minPos] = temp;
            }
        }
    }


}

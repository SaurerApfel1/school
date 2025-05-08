package Schule.Kapitel._08_Sortierverfahren._02_SortVisualizer;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SortVisualizer extends JPanel {

    private int[] array;

    public SortVisualizer(int size) {
        array = new int[size];
        fillArray();
    }

    // Zahlen füllen
    private void fillArray() {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = i*6;  // Höhe der Balken (in px)
        }
        for (int i = 0; i < array.length; i++) {
            int randomIndex = rand.nextInt(array.length);
            int temp = array[i];
            array[i] = array[randomIndex];
            array[randomIndex] = temp;
        }
    }

    // Zeichnet Formen
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / array.length;

        for (int i = 0; i < array.length; i++) {
            int height = array[i];
            g.setColor(Color.BLUE);
            g.fillRect(i * width, getHeight() - height, width-1, height);
        }
    }

    // BubbleSort
    public void bubbleSort() throws InterruptedException {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;

                    repaint();                  // Eingebaute funktion zum aktualisieren
                    Thread.sleep(30);   //kleine Pause für die Animation
                }
            }
        }
    }

    // SelectionSort
    public void selectionSort() throws InterruptedException {
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
                
                repaint();
                Thread.sleep(30);
            }
        }
    }

    public static JFrame createNewFrame() {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

        return frame;
    }

    public static void main(String[] args) {
        
        int arraySize = 100;

        //BubbleSort
        SortVisualizer visualizer = new SortVisualizer(arraySize);
        JFrame frame = createNewFrame();
        frame.add(visualizer);

        new Thread(() -> {
            try {
                visualizer.bubbleSort();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        //SelectionSort
        SortVisualizer visualizer2 = new SortVisualizer(arraySize);
        JFrame frame2 = createNewFrame();
        frame2.add(visualizer2);
  

        new Thread(() -> {
            try {
                visualizer2.selectionSort();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }
}
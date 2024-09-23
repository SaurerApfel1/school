package Privat.DatenReader;

import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            try (FileReader reader = new FileReader("C:\\Users\\kamog\\IdeaProjects\\school\\code\\Privat\\DatenReader\\art.txt")) {
                int data = reader.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = reader.read();
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

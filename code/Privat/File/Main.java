package Privat.File;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("resource/files/message.txt");


        if (file.exists()){
            System.out.println("Datei gefunden!");
            System.out.println("Path: "+file.getPath());
            System.out.println("Abs Path: "+file.getAbsolutePath());
            System.out.println("Ist eine Datei: "+file.isFile());
        }
        else {
            System.out.println("Datei nicht gefunden!");
        }

    }

}

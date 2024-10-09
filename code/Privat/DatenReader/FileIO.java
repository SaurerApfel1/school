package Privat.DatenReader;

import java.io.*;
import java.util.Scanner;

public class FileIO {
    public static void main(String[] args) throws IOException {

        BufferedWriter writer = new BufferedWriter(new FileWriter("code\\Privat\\DatenReader\\account.txt"));
        BufferedReader reader = new BufferedReader(new FileReader("code\\Privat\\DatenReader\\account.txt"));

        Scanner scan = new Scanner(System.in);

        System.out.print("<<Konto erstellen>>\nName: ");
        String name = scan.nextLine();
        writer.write(name+"\n");

        System.out.print("Passwort: ");
        String passwort = scan.nextLine();
        writer.write(passwort);

        writer.close();


        boolean logged = true;

        while (logged){

            System.out.println("<<Willkommen>>\n");
            System.out.println("Was wollen Sie tun?\n1.Sign in\n2.Passwort & Namen ändern\n3.Quit");

            int choice = scan.nextInt();

            switch (choice){
                case 1:break;
                case 2:break;
                case 3:logged = false;break;
            }


            String line;
            String[] data = new String[2];
            int i = 0;

            while ((line = reader.readLine())!=null){
                data[i] = line;
                i++;
            }

            for (String k : data) {
                System.out.println(k);
            }

            reader.close();
        }
    }
}
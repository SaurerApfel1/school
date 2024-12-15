package Privat.Zeit;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Uhrzeit {
    public static void main(String[] args) {

        //https://docs.oracle.com/javase/7/docs/api/java/text/SimpleDateFormat.html website für shortcuts

        Date currentDate = new Date();
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss");
        System.out.println(timeFormat.format(currentDate));

        SimpleDateFormat dateFormat = new SimpleDateFormat("MM.dd.yyyy");
        System.out.println(dateFormat.format(currentDate));

        SimpleDateFormat dateOfWeek = new SimpleDateFormat("EEEE");
        System.out.println(dateOfWeek.format(currentDate));

    }
}

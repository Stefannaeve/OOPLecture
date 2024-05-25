package fileReader;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MyFileReader {


    public void readFile(){
        try {

            // Lager Filen, pathen begynner fra starten av prosjektet
            File textFile = new File("text.txt");

            // Når du lager en scanner så kan du velge "hva" den scanner
            // eksempel System.in for terminal input eller en fil
            Scanner scanner = new Scanner(textFile);

            // Du leser fra filen på samme måte som du ville ha "lest" fra terminalen
            // Men du må passe på å stoppe å lese når filen er tom
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

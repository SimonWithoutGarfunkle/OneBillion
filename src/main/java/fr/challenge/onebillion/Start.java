package fr.challenge.onebillion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Start {

    public static Map<String, Row> processedData = new HashMap<>();
    public static Long proceed = 0L;

    public static List<String[]> data = new ArrayList<>();

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        //String fileName = "sample.txt";
        String fileName = "input.txt";


        FileReader.extractFileToList(fileName);
        data.forEach(Calculate::addLine);

        for (Map.Entry<String, Row> entry : processedData.entrySet()) {
            String cle = entry.getKey();
            Row valeur = entry.getValue();
            System.out.println("Clé : " + cle);
            System.out.println("   Température : " + valeur.temperature);
            System.out.println("   Compteur : " + valeur.counter);
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("Temps écoulé : " + elapsedTime + " millisecondes");
    }
}

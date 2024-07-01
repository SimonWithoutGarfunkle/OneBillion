package fr.challenge.onebillion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

    private static final Logger LOG = LoggerFactory.getLogger(FileReader.class);

    public static void extractFileToList(String filename) {
        List<String[]> result = new ArrayList<>();
        long count = 0;
        try {
            BufferedReader reader = new BufferedReader(new java.io.FileReader(filename));
            String line = reader.readLine();

            while (line != null) {
                count++;
                result.add(line.replace(",", ".").split(";"));
                line = reader.readLine();
                if (count == 10000) {
                    Start.data.addAll(result);
                    result.clear();
                    count=0;
                }
            }
            reader.close();
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}

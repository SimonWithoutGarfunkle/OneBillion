package fr.challenge.onebillion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GenerateMeasurements {

    private static final Logger LOG = LoggerFactory.getLogger(GenerateMeasurements.class);
    private static final String[] STATIONS = {
            "Hamburg", "Bulawayo", "Palembang", "St. John's", "Cracow", "Bridgetown",
            "Istanbul", "Roseau", "Conakry"
    };
    private static final int NUM_MEASUREMENTS = 1_000_000_000; // 1 billion
    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("input.txt"))) {
            for (int i = 0; i < NUM_MEASUREMENTS; i++) {
                String station = STATIONS[RANDOM.nextInt(STATIONS.length)];
                double temperature = -99.9 + (199.8 * RANDOM.nextDouble());
                writer.write(String.format("%s;%.1f%n", station, temperature));
            }
        } catch (IOException e) {
            LOG.error(e.getMessage());
        }
    }
}

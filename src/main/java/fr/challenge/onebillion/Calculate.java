package fr.challenge.onebillion;

import static fr.challenge.onebillion.Start.proceed;

public class Calculate {

    public static void addLine(String[] line) {
        Row innerMap = new Row(Double.parseDouble(line[1]), 1);
        proceed++;

        if (Start.processedData.containsKey(line[0])) {
            Row previousResult = Start.processedData.get(line[0]);
            Double doMaths = (previousResult.temperature * previousResult.counter + innerMap.temperature)
                    /(previousResult.counter++);

            Start.processedData.put(line[0], new Row( doMaths , previousResult.counter++));
        } else {
            Start.processedData.put(line[0], innerMap);
        }
        if (proceed % 100000 == 0 ) {
            System.out.println(proceed + " lignes traitées");
        }
    }
}

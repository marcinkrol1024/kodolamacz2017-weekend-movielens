package pl.kodolamacz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class CsvParserExample {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = CsvParserExample.class.getClassLoader()
                .getResourceAsStream("ml-latest-small/movies.csv");

        InputStreamReader reader = new InputStreamReader(inputStream);

        CSVParser parser = new CSVParser(reader, CSVFormat.RFC4180);

        // iter
        ArrayList<CSVRecord> list = new ArrayList<>();
        parser.forEach(record -> list.add(record));

        for (int i = 1; i < list.size(); i++) {
            CSVRecord record = list.get(i);
            String id = record.get(0);
            String title = record.get(1);
            System.out.println("id="+id + " title="+title);
            Integer.valueOf("123");
        }
    }

}

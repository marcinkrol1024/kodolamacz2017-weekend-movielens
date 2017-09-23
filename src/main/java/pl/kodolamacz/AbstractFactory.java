package pl.kodolamacz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class AbstractFactory<T> {

    private String filePath;

    public AbstractFactory(String filePath) {
        this.filePath = filePath;
    }

    List<T> readAll(){
        InputStream inputStream = CsvParserExample.class.getClassLoader()
                .getResourceAsStream(filePath);

        InputStreamReader reader = new InputStreamReader(inputStream);

        CSVFormat format = CSVFormat.RFC4180;
        CSVParser parser = null;
        try {
            parser = new CSVParser(reader, format);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Nie znalazłem pliku :(");
            return Collections.emptyList();
        }

        // iter
        ArrayList<CSVRecord> list = new ArrayList<>();
        parser.forEach(record -> list.add(record));

        List<T> result = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            CSVRecord record = list.get(i);
            result.add(parse(record));
        }
        return result;
    }

    abstract T parse(CSVRecord record);

}

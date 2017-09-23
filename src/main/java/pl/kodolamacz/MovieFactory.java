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

public class MovieFactory {

    String filePath;

    public MovieFactory(String filePath) {
        this.filePath = filePath;
    }

    List<Movie> readAll(){
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

        List<Movie> result = new ArrayList<>();

        for (int i = 1; i < list.size(); i++) {
            CSVRecord record = list.get(i);
            result.add(parse(record));
        }
        return result;
    }

    Movie parse(CSVRecord record){
        Integer id = Integer.valueOf(record.get(0));
        String title = record.get(1);
        String genres = record.get(2);
        return new Movie(id, title, genres);
    }

}

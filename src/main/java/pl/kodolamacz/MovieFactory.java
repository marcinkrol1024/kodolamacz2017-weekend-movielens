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

public class MovieFactory extends AbstractFactory<Movie> {

    public MovieFactory(String filePath) {
        super("ml-latest-small/movies.csv");
    }

    @Override
    Movie parse(CSVRecord record){
        Integer id = Integer.valueOf(record.get(0));
        String title = record.get(1);
        String genres = record.get(2);
        return new Movie(id, title, genres);
    }

}

package pl.kodolamacz;

import org.apache.commons.csv.CSVRecord;

public class MovieFactory extends AbstractFactory<Movie> {

    public MovieFactory() {
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

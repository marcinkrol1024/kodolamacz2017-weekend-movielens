package pl.kodolamacz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MovieCsvReader {

  private final MovieFactory movieFactory;

  public MovieCsvReader(MovieFactory movieFactory) {
    this.movieFactory = movieFactory;
  }

  public List<Movie> read(String csvFile) throws IOException {
    try (InputStreamReader moviesReader = new InputStreamReader(resourceAsStream(csvFile))) {
      CSVParser csvParser = new CSVParser(moviesReader, CSVFormat.RFC4180.withSkipHeaderRecord());
      List<Movie> movies = new ArrayList<>();
      Iterator<CSVRecord> movieRecords = csvParser.iterator();
      movieRecords.next(); // skip header
      while (movieRecords.hasNext()) {
        movies.add(movieFactory.parse(movieRecords.next()));
      }
      return movies;
    }
  }

  public List<Movie> readJava8(String csvFile) throws IOException {
    try (InputStreamReader moviesReader = new InputStreamReader(resourceAsStream(csvFile))) {
      CSVParser csvParser = new CSVParser(moviesReader, CSVFormat.RFC4180);
      return StreamSupport.stream(csvParser.spliterator(), false)
          .skip(1)
          .map(movieFactory::parse)
          .collect(Collectors.toList());
    }
  }

  private InputStream resourceAsStream(String csvFile) {
    return CsvParserExample.class.getClassLoader().getResourceAsStream(csvFile);
  }
}

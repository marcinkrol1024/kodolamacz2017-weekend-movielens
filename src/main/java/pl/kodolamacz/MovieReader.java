package pl.kodolamacz;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class MovieReader {

  private MovieFactory movieFactory;

  public MovieReader(MovieFactory movieFactory) {
    this.movieFactory = movieFactory;
  }

  public List<Movie> read(String csvFile) throws IOException {
    try (InputStreamReader reader = new InputStreamReader(loadFromResources(csvFile))) {
      CSVParser parser = new CSVParser(reader, CSVFormat.RFC4180);
      return StreamSupport.stream(parser.spliterator(), false)
          .skip(1)
          .map(movieFactory::parse)
          .collect(Collectors.toList());
    }
  }

  private InputStream loadFromResources(String csvFile) {
    return CsvParserExample.class.getClassLoader().getResourceAsStream(csvFile);
  }
}

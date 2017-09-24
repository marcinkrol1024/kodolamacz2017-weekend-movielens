package pl.kodolamacz.solutions;

import pl.kodolamacz.Movie;
import pl.kodolamacz.MovieCsvReader;
import pl.kodolamacz.MovieFactory;

import java.io.IOException;
import java.util.List;

public class MoviesCount {
  public static void main(String[] args) throws IOException {
    MovieCsvReader movieCsvReader = new MovieCsvReader(new MovieFactory());
    List<Movie> movies = movieCsvReader.read("ml-latest-small/movies.csv");
    System.out.println(String.format("There are %d movies.", movies.size()));
  }
}

package pl.kodolamacz.solutions;

import pl.kodolamacz.MovieFactory;
import pl.kodolamacz.MovieReader;

import java.io.IOException;

public class MoviesCount {
  public static void main(String[] args) throws IOException {
    MovieFactory movieFactory = new MovieFactory();
    MovieReader movieReader = new MovieReader(movieFactory);
    System.out.println(movieReader.read("ml-latest-small/movies.csv").size());
  }
}

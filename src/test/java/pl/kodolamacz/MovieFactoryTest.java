package pl.kodolamacz;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;


public class MovieFactoryTest {

    @Test
    public void shouldLoadAllMoviesTest(){
        // given
        MovieFactory factory = new MovieFactory();
        // when
        List<Movie> movies = factory.readAll();

        // then
        assertTrue(movies.size() > 0);
    }

}

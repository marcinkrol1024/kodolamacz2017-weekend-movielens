package pl.kodolamacz;

import org.junit.Test;

import java.util.List;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class MovieFactoryTest {

    @Test
    public void shouldLoadAllMoviesTest(){
        // given
        MovieFactory factory = new MovieFactory();
        // when
        List<Movie> movies = factory.readAll();

        // then
        assertThat(movies.size(), is(greaterThan(0)));
        assertThat(movies, hasSize(greaterThanOrEqualTo(1)));
    }

}

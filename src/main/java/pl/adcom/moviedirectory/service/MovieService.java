package pl.adcom.moviedirectory.service;

import org.springframework.stereotype.Service;
import pl.adcom.moviedirectory.model.Movie;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class MovieService {

    private List<Movie> movies;

    public List<Movie> getMovies() {

        return Arrays.asList(
                new Movie("Furia"),
                new Movie("Rambo"),
                new Movie("Shreck")
        );
    }

    public Movie getMovie(UUID id) {
        Movie movie = new Movie("Movie " + id);
        return movie;
    }

    public Movie createMovie(Movie movie) {
        movie.setId(UUID.randomUUID());
        //TODO create movie
        return movie;
    }

    public Movie updateMovie(UUID id, Movie movie) {
        movie.setId(id);
        //TODO update movie
        return movie;
    }

    public void deleteMovie(UUID id) {
        // TODO delete movie
    }
}

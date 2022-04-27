package pl.adcom.moviedirectory.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pl.adcom.moviedirectory.model.Movie;
import pl.adcom.moviedirectory.service.MovieService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/v1/movies")
public class MovieApiController {

    private MovieService movieService;

    @Autowired
    public MovieApiController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @GetMapping("{id}")
    Movie getMovie(@PathVariable UUID id) {
        return movieService.getMovie(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    Movie createMovie(@RequestBody Movie movie) {
        return movieService.createMovie(movie);
    }

    @PutMapping("{id}")
    Movie updateMovie(@PathVariable UUID id, @RequestBody Movie movie) {
        return movieService.updateMovie(id, movie);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT) // http 204
    void deleteMovie(@PathVariable UUID id) {
        movieService.deleteMovie(id);
    }

    /**
    CRUD - create
    POST /movies

    READ
     GET - /movies
     GET - /movies/{id}

    UPDATE
     PUT - /movies/{id}

     DELETE
    DELETE - /movies/{id}
     **/
}

package pl.adcom.moviedirectory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.adcom.moviedirectory.service.MovieService;

@Controller
@RequestMapping("movies")
@RequiredArgsConstructor
public class MovieViewController {

    private MovieService movieService;

    @Autowired
    public MovieViewController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    String indexView(Model model) {
        model.addAttribute("movies", movieService.getMovies());
        return "index";
    }
}

package com.microservice.movieinfoservice.resource;

import com.microservice.movieinfoservice.models.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieResource {

    @GetMapping("/{id}")
    public Movie getMovieInfo(@PathVariable("id") String id) {
        return new Movie(id, "Test name");
    }
}

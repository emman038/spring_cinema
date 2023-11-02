package com.bnta.spring_cinema.services;

import com.bnta.spring_cinema.models.Movie;
import com.bnta.spring_cinema.models.MovieToUpdate;
import com.bnta.spring_cinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public List<Movie> getMovies() {
        if (!movieRepository.findAll().isEmpty()){
            return movieRepository.findAll();
        }
        return null;
    }

    public Optional<Movie> getMoviesById(long id){
        return movieRepository.findById(id);
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }

    public void updateMovie(long id, MovieToUpdate movieToUpdate){
        Optional<Movie> checkMovie = movieRepository.findById(id);
        if (checkMovie.isPresent()) {
            Movie movie = checkMovie.get();
            if (movieToUpdate.getTitle() != null) {
                movie.setTitle(movieToUpdate.getTitle());
            }
            if (movieToUpdate.getDuration() > 0) {
                movie.setDuration(movieToUpdate.getDuration());
            }
            if (movieToUpdate.getRating() != null) {
                movie.setRating(movieToUpdate.getRating());
            }
            movieRepository.save(movie);
        }
    }

    public void deleteMovie(long id){
        movieRepository.deleteById(id);
    }


}

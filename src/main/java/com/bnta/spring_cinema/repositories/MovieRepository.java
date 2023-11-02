package com.bnta.spring_cinema.repositories;

import com.bnta.spring_cinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long>{
}

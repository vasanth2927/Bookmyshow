package com.example.Bookmyshow.Repsitory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Bookmyshow.Entity.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Integer> {

}

package com.goulart.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goulart.dslist.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

	
}

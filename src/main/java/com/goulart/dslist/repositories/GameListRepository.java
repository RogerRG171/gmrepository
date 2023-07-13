package com.goulart.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goulart.dslist.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}

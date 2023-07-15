package com.goulart.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.goulart.dslist.dto.GameListDTO;
import com.goulart.dslist.dto.ReplacementDTO;
import com.goulart.dslist.projections.GameMinProjection;
import com.goulart.dslist.services.GameListService;
import com.goulart.dslist.services.GameService;

@RestController
@RequestMapping(value = "/lists")
public class GameListController {

	@Autowired
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll(){
		List<GameListDTO> result = gameListService.findAll();
		return result;
	}
	
	@GetMapping(path = "/{id}/games")
	public List<GameMinProjection> findGameByListId(@PathVariable("id") Long id){
		List<GameMinProjection> result = gameService.findGameByListId(id);
		return result;
	}
	
	@PostMapping(path = "/{listId}/replacement")
	public void move(@PathVariable("listId") Long listId, @RequestBody ReplacementDTO body){
		 gameListService.move(listId, body.getSourceIndex(), body.getDestinationIndex());
	}
}

package com.example.brightcove.controller;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.brightcove.entity.Move;
import com.example.brightcove.entity.PokemonRelation;
import com.example.brightcove.service.PokemonService;

@RestController
@RequestMapping("/brightcove")
public class PokemonController {
	
	@Autowired
	private PokemonService pokemonService;

	private static final String MESSAGE_FORMAT = "Hello %s!";

	@RequestMapping(path = "/hello", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<String> helloWorldPost(@RequestParam(value = "name", defaultValue = "World") String name) {
		return ResponseEntity.ok(createResponse(name));
	}

	/**
	 * Endpoint to handle request to determine the damage between 2 pokemons
	 * @param first		pokemon
	 * @param second	pokemon
	 * @param limit		the number(limit) of movements in common to display
	 * @return
	 */
	@GetMapping("/damage/{first}/{second}")
	public ResponseEntity<String> getRelation(
			@PathVariable(required = true) Integer first, 
			@PathVariable(required = true) Integer second,
			@RequestParam(required = false) Integer limit) {
		
		List<PokemonRelation> list = new ArrayList<PokemonRelation>();
		list.add(pokemonService.fetchDataFor(first));
		list.add(pokemonService.fetchDataFor(second));
		
		StringBuilder response = new StringBuilder().append("Resolution: ").append("<br />");
		
		if(list.size() == 2) {
			if(pokemonService.canDoubleDamage(list.get(0), list.get(1))) {
				response.append("* pokemons type '").append(list.get(0).getName())
					.append("' is able to double damage pokemons of type '").append(list.get(1).getName())
					.append("'");
			} else {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' is not able to double damage pokemons of type '").append(list.get(1).getName())
				.append("'");
			} response.append("<br />");
			
			if(pokemonService.receivesHalfDamageFrom(list.get(0), list.get(1))) {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' receive half of the damage from pokemons of type '").append(list.get(1).getName())
				.append("'");
			} else {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' does not receive half of the damage from pokemons of type '").append(list.get(1).getName())
				.append("'");
			} response.append("<br />");
			
			if(pokemonService.receivesNoDamageFrom(list.get(0), list.get(1))) {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' receive no damage from pokemons of type '").append(list.get(1).getName())
				.append("'");
			} else {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' receive damage from pokemons of type '").append(list.get(1).getName())
				.append("'");
			} response.append("<br />");
			
			List<Move> moves =  pokemonService.findMovesInCommon(list.get(0), list.get(1));
			if(moves.size() > 0) {
				response.append("* following is the list of movements in common between these 2 pokemon types:")
				.append("<ul>");
				
				if( limit != null && limit > 0 ) {
					for(int i=0; i < limit; i++) {
						response.append("<li>").append(moves.get(i).getName()).append("</li>");
					}
				} else {
					for(Move move : moves) {
						response.append("<li>").append(move.getName()).append("</li>");
					}
				} response.append("</ul>");
				
			} else {
				response.append("* pokemons type '").append(list.get(0).getName())
				.append("' and pokemons of type '").append(list.get(1).getName())
				.append("' does not have movements in common");
			}
			
		} else if (list.size() < 2) {
			response.append("not enough pokemons to compare");
		}
		
		return ResponseEntity.ok(response.toString());
		
	}
	
	@GetMapping("/healthcheck")
	public ResponseEntity<String> healthcheck() {
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private String createResponse(String name) {
		return new JSONObject().put("Output", String.format(MESSAGE_FORMAT, name)).toString();
	}

}

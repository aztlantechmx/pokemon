package com.example.brightcove.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.example.brightcove.entity.PokemonRelation;
import com.example.brightcove.service.PokemonService;

@DisplayName("Tests for PokemonController")
public class PokemonControllerTest {

	@Autowired
	private PokemonController pokemonController;
	
	@Autowired
	private PokemonService pokemonService;

	/*@Test TODO: complete test cases
    @DisplayName("Pokemon Controller GET request")
    void testGetRequest() {
		when(pokemonService.canDoubleDamage(new PokemonRelation(), new PokemonRelation())).thenReturn(true);
		ResponseEntity<String> responseEntity = pokemonController.getRelation(12, 7, null);
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}*/
}

package com.example.brightcove.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@DisplayName("Tests for PokemonController")
public class PokemonControllerTest {

	@Autowired
	private PokemonController pokemonController;

	@Test
    @DisplayName("Basic test for GET request")
    void testGetRequest() {
		ResponseEntity<?> responseEntity = pokemonController.healthcheck();
		assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
	}
}

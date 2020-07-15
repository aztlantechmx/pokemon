package com.example.brightcove.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.brightcove.entity.DoubleDamageTo;
import com.example.brightcove.entity.HalfDamageFrom;
import com.example.brightcove.entity.Move;
import com.example.brightcove.entity.NoDamageFrom;
import com.example.brightcove.entity.PokemonRelation;

@Service
public class PokemonService {

	/**
	 * A function to retrieve data by calling pokeapi for the given pokemonTypeId
	 * @param pokemonTypeId
	 * @return pokemon type data
	 */
	public PokemonRelation fetchDataFor(int pokemonTypeId){
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		HttpEntity<String> httpRequest = new HttpEntity<String>("parameters", headers);
		String targetUrl1 = new StringBuilder().append("https://pokeapi.co/api/v2/type/").append(pokemonTypeId).toString();

		RestTemplate template = new RestTemplate();
		ResponseEntity<PokemonRelation> response = template.exchange(targetUrl1, HttpMethod.GET, httpRequest, PokemonRelation.class);
		
		System.out.println(response.toString());
		
		PokemonRelation pokemon = response.getBody();
		return pokemon;
	}
	
	/**
	 * A function to determine if the first pokemon can damage the second pokemon
	 * @param first		pokemon
	 * @param second	pokemon
	 * @return			true|false
	 */
	public boolean canDoubleDamage(PokemonRelation first, PokemonRelation second) {
		for(DoubleDamageTo damage : first.getDamage_relations().getDouble_damage_to()) {
			if(damage.getName().equals(second.getName())) {
				return true;
			}
		} return false;
	}
	
	/**
	 * A function to determine if the first pokemon receives half of the damage from the second pokemon
	 * @param first		pokemon
	 * @param second	pokemon
	 * @return			true|false
	 */
	public boolean receivesHalfDamageFrom(PokemonRelation first, PokemonRelation second) {
		for(HalfDamageFrom damage : first.getDamage_relations().getHalf_damage_from()) {
			if(damage.getName().equals(second.getName())) {
				return true;
			}
		} return false;
	}
	
	/**
	 * A function to determine if the first pokemon receives no damage from the second pokemon
	 * @param first		pokemon
	 * @param second	pokemon
	 * @return			true|false
	 */
	public boolean receivesNoDamageFrom(PokemonRelation first, PokemonRelation second) {
		for(NoDamageFrom damage : first.getDamage_relations().getNo_damage_from()) {
			if(damage.getName().equals(second.getName())) {
				return true;
			}
		} return false;
	}
	
	/**
	 * A function to find the movements in common between 2 pokemons
	 * @param first		pokemon
	 * @param second	pokemon
	 * @return			list of movements
	 */
	public List<Move> findMovesInCommon(PokemonRelation first, PokemonRelation second) {
		Map<String,String> movesMap = new HashMap<>();
		List<Move> result = new ArrayList<>();
		
		for(Move move : first.getMoves()) {
			if(!movesMap.containsKey(move.getName())) {
				movesMap.put(move.getName(), move.getUrl());
			}
		}
		
		for(Move move : second.getMoves()) {
			if(movesMap.containsKey(move.getName())) {
				result.add(move);
			}
		} return result;
	}
	
}

package com.example.brightcove.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonRelation {

	private Integer id;
	private String name;
	private DamageRelations damage_relations;
	private Generation generation;
	private Move[] moves;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public DamageRelations getDamage_relations() {
		return damage_relations;
	}

	public void setDamage_relations(DamageRelations damage_relations) {
		this.damage_relations = damage_relations;
	}

	public Generation getGeneration() {
		return generation;
	}

	public void setGeneration(Generation generation) {
		this.generation = generation;
	}

	public Move[] getMoves() {
		return moves;
	}

	public void setMoves(Move[] moves) {
		this.moves = moves;
	}

	@Override
	public String toString() {
		return "PokemonRelation [id=" + id + ", name=" + name + ", damage_relations=" + damage_relations
				+ ", generation=" + generation + ", moves=" + Arrays.toString(moves) + "]";
	}

}

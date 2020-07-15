package com.example.brightcove.entity;

import java.util.Arrays;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DamageRelations {
	private DoubleDamageFrom[] double_damage_from;
	private DoubleDamageTo[] double_damage_to;
	private HalfDamageFrom[] half_damage_from;
	private HalfDamageTo[] half_damage_to;
	private NoDamageFrom[] no_damage_from;
	private NoDamageTo[] no_damage_to;

	public DoubleDamageFrom[] getDouble_damage_from() {
		return double_damage_from;
	}

	public void setDouble_damage_from(DoubleDamageFrom[] double_damage_from) {
		this.double_damage_from = double_damage_from;
	}

	public DoubleDamageTo[] getDouble_damage_to() {
		return double_damage_to;
	}

	public void setDouble_damage_to(DoubleDamageTo[] double_damage_to) {
		this.double_damage_to = double_damage_to;
	}

	public HalfDamageFrom[] getHalf_damage_from() {
		return half_damage_from;
	}

	public void setHalf_damage_from(HalfDamageFrom[] half_damage_from) {
		this.half_damage_from = half_damage_from;
	}

	public HalfDamageTo[] getHalf_damage_to() {
		return half_damage_to;
	}

	public void setHalf_damage_to(HalfDamageTo[] half_damage_to) {
		this.half_damage_to = half_damage_to;
	}

	public NoDamageFrom[] getNo_damage_from() {
		return no_damage_from;
	}

	public void setNo_damage_from(NoDamageFrom[] no_damage_from) {
		this.no_damage_from = no_damage_from;
	}

	public NoDamageTo[] getNo_damage_to() {
		return no_damage_to;
	}

	public void setNo_damage_to(NoDamageTo[] no_damage_to) {
		this.no_damage_to = no_damage_to;
	}

	@Override
	public String toString() {
		return "DamageRelations [double_damage_from=" + Arrays.toString(double_damage_from) + ", double_damage_to="
				+ Arrays.toString(double_damage_to) + ", half_damage_from=" + Arrays.toString(half_damage_from)
				+ ", half_damage_to=" + Arrays.toString(half_damage_to) + ", no_damage_from="
				+ Arrays.toString(no_damage_from) + ", no_damage_to=" + Arrays.toString(no_damage_to) + "]";
	}

}

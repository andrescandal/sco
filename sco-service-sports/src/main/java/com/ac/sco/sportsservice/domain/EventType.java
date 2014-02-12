package com.ac.sco.sportsservice.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class EventType {

	@Id 
    @GeneratedValue
	private Integer id;
	
	@Column(length=40)
	private String name;
	
	@ManyToOne(optional=false)
	private TournamentType tournamentType;

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

	public void setTournamentType(TournamentType tournamentType) {
		this.tournamentType = tournamentType;
	}

	public TournamentType getTournamentType() {
		return tournamentType;
	}
}

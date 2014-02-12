package com.ac.sco.sportsservice.domain;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Group of matches, per group of teams, date, etc.
 * @author Gteolis
 */
@Entity
@Table(name="groups")
public class Group {

	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(length=20)
	private String name;
	
	@ManyToOne(optional=false)
	private Tournament tournament;
	
	@OneToMany(mappedBy="group", cascade=CascadeType.REMOVE)
	private Collection<Match> matchs;

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMatchs(Collection<Match> matchs) {
		this.matchs = matchs;
	}

	public Collection<Match> getMatchs() {
		return matchs;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}
	
	
}

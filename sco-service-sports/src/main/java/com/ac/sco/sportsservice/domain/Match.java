package com.ac.sco.sportsservice.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

 
@Entity
@Table(name="matchs")
public class Match {
 
    @Id 
    @GeneratedValue
    private Long id;
    
    @Column
    private Date datetime;
    
    @ManyToOne(optional=false) 
    private Group group;
    
    @ManyToOne(optional=true) 
    private Team team1;
    
    @ManyToOne(optional=true) 
    private Team team2;
    
    @ManyToOne(optional=true)
    private Place place;
    
    @OneToMany (mappedBy="match", cascade=CascadeType.REMOVE)
    private Collection<Event> events;
    
    @Column(length=40)
    private String scoreTeam1;
    
    @Column(length=40)
    private String scoreTeam2;
    
    @ManyToOne(optional=false)
    private ScoreType scoreType;

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public void setEvents(Collection<Event> events) {
		this.events = events;
	}

	public Collection<Event> getEvents() {
		return events;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Group getGroup() {
		return group;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public Place getPlace() {
		return place;
	}
	
	public void setScoreTeam1(String scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	public String getScoreTeam1() {
		return scoreTeam1;
	}

	public void setScoreTeam2(String scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

	public String getScoreTeam2() {
		return scoreTeam2;
	}

	public void setScoreType(ScoreType scoreType) {
		this.scoreType = scoreType;
	}

	public ScoreType getScoreType() {
		return scoreType;
	}
    
    
}
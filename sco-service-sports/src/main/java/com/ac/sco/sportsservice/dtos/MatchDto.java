package com.ac.sco.sportsservice.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "datetime", "team1", "team2", "placeDto", "scoreTeam1", "scoreTeam2", "scoreTypeDto", "eventList" })
@XmlAccessorType(XmlAccessType.FIELD)
public class MatchDto {
 
    private Long id;
    
    private String datetime;

    private TeamDto team1;
     
    private TeamDto team2;
    
    private PlaceDto placeDto;
    
    private String scoreTeam1;
    
    private String scoreTeam2;
    
    private ScoreTypeDto scoreTypeDto;
    
    @XmlElementWrapper(name="events")
	@XmlElement(name="event")
    private List<EventDto> eventList = new ArrayList<EventDto>();

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the team1
	 */
	public TeamDto getTeam1() {
		return team1;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(TeamDto team1) {
		this.team1 = team1;
	}

	/**
	 * @return the team2
	 */
	public TeamDto getTeam2() {
		return team2;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(TeamDto team2) {
		this.team2 = team2;
	}

	/**
	 * @return the placeDto
	 */
	public PlaceDto getPlaceDto() {
		return placeDto;
	}

	/**
	 * @param placeDto the placeDto to set
	 */
	public void setPlaceDto(PlaceDto placeDto) {
		this.placeDto = placeDto;
	}

	/**
	 * @return the eventList
	 */
	public List<EventDto> getEventList() {
		return eventList;
	}

	/**
	 * @param eventList the eventList to set
	 */
	public void setEventList(List<EventDto> eventList) {
		this.eventList = eventList;
	}

	public void setDatetime(String datetime) {
		this.datetime = datetime;
	}

	public String getDatetime() {
		return datetime;
	}

	/**
	 * @return the scoreTeam1
	 */
	public String getScoreTeam1() {
		return scoreTeam1;
	}

	/**
	 * @param scoreTeam1 the scoreTeam1 to set
	 */
	public void setScoreTeam1(String scoreTeam1) {
		this.scoreTeam1 = scoreTeam1;
	}

	/**
	 * @return the scoreTeam2
	 */
	public String getScoreTeam2() {
		return scoreTeam2;
	}

	/**
	 * @param scoreTeam2 the scoreTeam2 to set
	 */
	public void setScoreTeam2(String scoreTeam2) {
		this.scoreTeam2 = scoreTeam2;
	}

	/**
	 * @param scoreTypeDto the scoreTypeDto to set
	 */
	public void setScoreTypeDto(ScoreTypeDto scoreTypeDto) {
		this.scoreTypeDto = scoreTypeDto;
	}

	/**
	 * @return the scoreTypeDto
	 */
	public ScoreTypeDto getScoreTypeDto() {
		return scoreTypeDto;
	}

	
	
	
}
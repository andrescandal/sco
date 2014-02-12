package com.ac.sco.sportsservice.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TournamentsDto {

	@XmlElementWrapper(name="tournaments")
	@XmlElement(name="tournament")
	List<TournamentDto> tournamentList= new ArrayList<TournamentDto>();

	public void setTournamentList(List<TournamentDto> tournamentList) {
		this.tournamentList = tournamentList;
	}

	public List<TournamentDto> getTournamentList() {
		return tournamentList;
	}
	
}

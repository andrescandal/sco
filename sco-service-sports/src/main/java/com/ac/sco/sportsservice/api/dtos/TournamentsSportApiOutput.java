package com.ac.sco.sportsservice.api.dtos;

import com.ac.sco.sportsservice.dtos.TournamentsDto;

public class TournamentsSportApiOutput extends SportsApiOutput {

	private TournamentsDto tournamentsDto;

	public void setTournamentsDto(TournamentsDto tournamentsDto) {
		this.tournamentsDto = tournamentsDto;
	}

	public TournamentsDto getTournamentsDto() {
		return tournamentsDto;
	}

}

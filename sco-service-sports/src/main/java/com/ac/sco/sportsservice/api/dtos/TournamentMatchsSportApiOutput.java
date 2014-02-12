package com.ac.sco.sportsservice.api.dtos;

import com.ac.sco.sportsservice.dtos.TournamentDto;

public class TournamentMatchsSportApiOutput extends SportsApiOutput {

	private TournamentDto tournamentDto;

	/**
	 * @return the tournamentDto
	 */
	public TournamentDto getTournamentDto() {
		return tournamentDto;
	}

	/**
	 * @param tournamentDto the tournamentDto to set
	 */
	public void setTournamentDto(TournamentDto tournamentDto) {
		this.tournamentDto = tournamentDto;
	}

}

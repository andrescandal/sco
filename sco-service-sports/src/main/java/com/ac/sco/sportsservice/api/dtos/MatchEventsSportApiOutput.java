package com.ac.sco.sportsservice.api.dtos;

import com.ac.sco.sportsservice.dtos.MatchDto;

public class MatchEventsSportApiOutput extends SportsApiOutput {

	private MatchDto matchDto;

	/**
	 * @return the matchDto
	 */
	public MatchDto getMatchDto() {
		return matchDto;
	}

	/**
	 * @param matchDto the matchDto to set
	 */
	public void setMatchDto(MatchDto matchDto) {
		this.matchDto = matchDto;
	}

}

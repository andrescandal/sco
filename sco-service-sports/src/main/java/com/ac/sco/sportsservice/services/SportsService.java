package com.ac.sco.sportsservice.services;

import com.ac.sco.sportsservice.dtos.MatchDto;
import com.ac.sco.sportsservice.dtos.TournamentDto;
import com.ac.sco.sportsservice.dtos.TournamentsDto;
import com.ac.sco.sportsservice.exception.SportsServiceException;

/**
 * 
 * Service interface for sports information services.
 * @author Gteolis
  */
public interface SportsService {

	/**
	 * Get all tournaments.
	 * @return
	 */
	TournamentsDto getTournaments() throws SportsServiceException;

	/**
	 * Get the tournament with all the info and all the matchs.
	 * @param tournamentId 
	 * @return
	 * @throws SportsServiceException 
	 */
	TournamentDto getTournamentMatchs(Long tournamentId) throws SportsServiceException;

	/**
	 * Gets the MatchDto of the given matchId
	 * @param matchId
	 * @return the matchDto with the events of the match
	 */
	MatchDto getMatchEvents(Long matchId) throws SportsServiceException;

}

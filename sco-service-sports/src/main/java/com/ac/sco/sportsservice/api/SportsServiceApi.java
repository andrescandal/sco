package com.ac.sco.sportsservice.api;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.ac.sco.sportsservice.api.dtos.MatchEventsSportApiOutput;
import com.ac.sco.sportsservice.api.dtos.TournamentMatchsSportApiOutput;
import com.ac.sco.sportsservice.api.dtos.TournamentsSportApiOutput;


/**
 * The SportsServiceApi provides information for online sports activities.
 * @author Gabriel Teolis.
 */
@WebService
public interface SportsServiceApi {
	
	/**
	 * Returns all the tournaments that can be viewed in the system.
	 * @param userKey the userKey for authenticating in the service
	 * @return TournamentsSportApiOutput with the available tournaments.
	 */
	@Path("/tournaments/{userkey}")
    @GET
    @Produces("application/json")
	TournamentsSportApiOutput getTournaments(@PathParam("userkey") String userKey);
	
	/**
	 * Returns all the matches in a given tournament.
	 * @param tournamentId the tournamentId
	 * @param userKey the userKey for authenticating in the service
	 * @return TournamentMatchsSportApiOutput with the available matches in the requested tournament.
	 */
	@Path("tournament/{tournamentId}/matchs/{userkey}/")
    @GET
    @Produces("application/json")
	TournamentMatchsSportApiOutput getTournamentMatchs(
			@PathParam("tournamentId") Long tournamentId,
			@PathParam("userkey") String userKey);
	
	/**
	 * Returns all the events for a given match.
	 * @param matchId the matchId
	 * @param userKey the userKey for authenticating in the service
	 * @return MatchEventsSportApiOutput with the match info and current events for the requested match.
	 */
	@Path("match/{matchId}/events/{userkey}/")
    @GET
    @Produces("application/json")
	MatchEventsSportApiOutput getMatchEvents(
			@PathParam("matchId") Long matchId,
			@PathParam("userkey") String userKey);
	
	
}
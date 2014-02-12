package com.ac.sco.sportsservice.api.impl;

import javax.jws.WebService;
import javax.ws.rs.Path;

import org.apache.log4j.Logger;

import com.ac.sco.sportsservice.api.SportsServiceApi;
import com.ac.sco.sportsservice.api.dtos.MatchEventsSportApiOutput;
import com.ac.sco.sportsservice.api.dtos.SportsApiInput;
import com.ac.sco.sportsservice.api.dtos.TournamentMatchsSportApiOutput;
import com.ac.sco.sportsservice.api.dtos.TournamentsSportApiOutput;
import com.ac.sco.sportsservice.base.SpringContext;
import com.ac.sco.sportsservice.dtos.MatchDto;
import com.ac.sco.sportsservice.dtos.TournamentDto;
import com.ac.sco.sportsservice.dtos.TournamentsDto;
import com.ac.sco.sportsservice.exception.AuthenticationFailedException;
import com.ac.sco.sportsservice.exception.SportsServiceException;
import com.ac.sco.sportsservice.services.AuthServiceDelegate;
import com.ac.sco.sportsservice.services.SportsService;

@WebService(endpointInterface = "com.ac.sco.sportsservice.api.SportsServiceApi")
@Path("/sports")
public class SportsServiceApiImpl implements SportsServiceApi {

	private SportsService sportsService = SpringContext.getContext().getBean(SportsService.class);
	
	private AuthServiceDelegate authServiceDelegate = SpringContext.getContext().getBean(
			AuthServiceDelegate.class);
	
	private static Logger logger = Logger.getLogger(SportsServiceApiImpl.class);

	@Override
	public TournamentsSportApiOutput getTournaments(String userKey) {
		
		SportsApiInput sportsApiInput = new SportsApiInput();
		sportsApiInput.getAuthInput().setUserKey(userKey);
		TournamentsDto tournamentsDto = null;
		TournamentsSportApiOutput tournamentsSportApiOutput = new TournamentsSportApiOutput();
		try {
			authenticate(sportsApiInput);
			
			logger.debug("Getting Tournaments info ");
			tournamentsDto = sportsService.getTournaments();
			tournamentsSportApiOutput.getApiResult().setServiceOk();
			tournamentsSportApiOutput.setTournamentsDto(tournamentsDto);
			logger.debug("Tournaments info delivered successfully");
		} catch (AuthenticationFailedException e) {
			logger.error("User not authenticated for service getTournaments");
			tournamentsSportApiOutput.getApiResult().setServiceErrorAuth(e.getAuthResult().getErrorDescription());
		} catch (SportsServiceException e) {
			logger.error("Error in getTournaments() invocation", e);
			tournamentsSportApiOutput.getApiResult().setServiceErrorInput(e.getMessage());
		}
		
		return tournamentsSportApiOutput;
		
	}

	private void authenticate(SportsApiInput sportsApiInput)
			throws AuthenticationFailedException {
		logger.debug("Authenticating userkey " + sportsApiInput.getAuthInput().getUserKey()+ " in service 'getTournaments'");
		authServiceDelegate.authenticate(sportsApiInput.getAuthInput());
		logger.debug("Authenticated");
	}

	@Override
	public TournamentMatchsSportApiOutput getTournamentMatchs(Long tournamentId,
			String userKey) {
		
		SportsApiInput sportsApiInput = new SportsApiInput();
		sportsApiInput.getAuthInput().setUserKey(userKey);
		TournamentDto tournamentDto = null;
		TournamentMatchsSportApiOutput tournamentMatchsSportApiOutput = new TournamentMatchsSportApiOutput();
		try {
			authenticate(sportsApiInput);
			
			logger.debug("Getting Tournament info with id " + tournamentId);
			tournamentDto = sportsService.getTournamentMatchs(tournamentId);
			tournamentMatchsSportApiOutput.getApiResult().setServiceOk();
			tournamentMatchsSportApiOutput.setTournamentDto(tournamentDto);
			logger.debug("Tournament Matchs info delivered successfully");
		} catch (AuthenticationFailedException e) {
			logger.error("User not authenticated for service getTournamentMatchs");
			tournamentMatchsSportApiOutput.getApiResult().setServiceErrorAuth(e.getAuthResult().getErrorDescription());
		}  catch (SportsServiceException e) {
			logger.error("Error in getTournamentMatchs() invocation", e);
			tournamentMatchsSportApiOutput.getApiResult().setServiceErrorInput(e.getMessage());
		}
		
		return tournamentMatchsSportApiOutput;
		
	}

	@Override
	public MatchEventsSportApiOutput getMatchEvents(Long matchId, String userKey) {
		
		SportsApiInput sportsApiInput = new SportsApiInput();
		sportsApiInput.getAuthInput().setUserKey(userKey);
		MatchDto matchDto = null;
		MatchEventsSportApiOutput matchEventsSportApiOutput = new MatchEventsSportApiOutput();
		try {
			authenticate(sportsApiInput);
			
			logger.debug("Getting Match info for match with id" + matchId);
			matchDto = sportsService.getMatchEvents(matchId);
			matchEventsSportApiOutput.getApiResult().setServiceOk();
			matchEventsSportApiOutput.setMatchDto(matchDto);
			logger.debug("Match events info delivered successfully");
		} catch (AuthenticationFailedException e) {
			logger.error("User not authenticated for service getMatchEvents");
			matchEventsSportApiOutput.getApiResult().setServiceErrorAuth(e.getAuthResult().getErrorDescription());
		}  catch (SportsServiceException e) {
			logger.error("Error in getTournamentMatchs() invocation", e);
			matchEventsSportApiOutput.getApiResult().setServiceErrorInput(e.getMessage());
		}
		
		return matchEventsSportApiOutput;
	}	
}

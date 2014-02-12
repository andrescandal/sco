package com.ac.sco.sports.services.impl;

import javax.annotation.Resource;

import junit.framework.Assert;

import org.junit.Test;

import com.ac.sco.base.AppTxBaseTest;
import com.ac.sco.sportsservice.dtos.MatchDto;
import com.ac.sco.sportsservice.dtos.TournamentDto;
import com.ac.sco.sportsservice.dtos.TournamentsDto;
import com.ac.sco.sportsservice.exception.SportsServiceException;
import com.ac.sco.sportsservice.services.SportsService;

public class SportsServiceTest extends AppTxBaseTest {

	@Resource
	private SportsService target;
	
	@Test
	public void getTournaments_AvailableTournaments_Sucess() throws SportsServiceException {
		
		System.out.println("Testeando getTournaments.");
		
		TournamentsDto result = target.getTournaments();
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getTournamentList());
	}
	
	@Test
	public void getTournamentMatchs_AvailableTournamentMatchs_Sucess() throws SportsServiceException {
		
		System.out.println("Testeando getTournamentMatchs.");
		
		TournamentDto result = target.getTournamentMatchs((long) 1);
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
	}
	
	@Test
	public void getMatchEvents_AvailableMatchs_Sucess() throws SportsServiceException {
		
		System.out.println("Testeando getMatchEvents.");
		
		MatchDto result = target.getMatchEvents((long) 1);
		
		Assert.assertNotNull(result);
		Assert.assertNotNull(result.getId());
	}
	
}

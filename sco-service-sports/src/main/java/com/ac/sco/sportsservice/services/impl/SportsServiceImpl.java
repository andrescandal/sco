package com.ac.sco.sportsservice.services.impl;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ac.sco.sportsservice.dao.GenericDao;
import com.ac.sco.sportsservice.domain.Event;
import com.ac.sco.sportsservice.domain.EventType;
import com.ac.sco.sportsservice.domain.Group;
import com.ac.sco.sportsservice.domain.Match;
import com.ac.sco.sportsservice.domain.Place;
import com.ac.sco.sportsservice.domain.ScoreType;
import com.ac.sco.sportsservice.domain.Team;
import com.ac.sco.sportsservice.domain.Tournament;
import com.ac.sco.sportsservice.domain.TournamentType;
import com.ac.sco.sportsservice.dtos.EventDto;
import com.ac.sco.sportsservice.dtos.EventTypeDto;
import com.ac.sco.sportsservice.dtos.GroupDto;
import com.ac.sco.sportsservice.dtos.MatchDto;
import com.ac.sco.sportsservice.dtos.PlaceDto;
import com.ac.sco.sportsservice.dtos.ScoreTypeDto;
import com.ac.sco.sportsservice.dtos.TeamDto;
import com.ac.sco.sportsservice.dtos.TournamentDto;
import com.ac.sco.sportsservice.dtos.TournamentTypeDto;
import com.ac.sco.sportsservice.dtos.TournamentsDto;
import com.ac.sco.sportsservice.exception.SportsServiceException;
import com.ac.sco.sportsservice.services.SportsService;

@Service
public class SportsServiceImpl implements SportsService {

	private static final String DATE_PATTERN = "MM/dd/yyyy";

	private static final String DATETIME_PATTERN = "MM/dd/yyyy HH:mm";

	@Resource
	private GenericDao dao;

	private static Logger logger = Logger.getLogger(SportsServiceImpl.class);

	@Override
	@Transactional
	public TournamentsDto getTournaments() {

		List<Tournament> tournaments = dao.findAll(Tournament.class);
		logger.debug("Tournaments encontrados: " + tournaments);

		TournamentsDto tournamentsDto = getTournamentsFromEntities(tournaments,
				false);

		return tournamentsDto;
	}

	@Override
	@Transactional
	public TournamentDto getTournamentMatchs(Long tournamentId) throws SportsServiceException {
		
		TournamentDto tournamentDto = null;
		try{
			logger.debug("Buscando Tournament con Id: " + tournamentId);
			Tournament t = dao.getById(Tournament.class, tournamentId);
			if (t == null) {
				throw new SportsServiceException("Tournament not found with id " + tournamentId);
			}
			
			logger.debug("Tournament encontrado con Id: " + tournamentId);
			tournamentDto = getTournamentDtoFromEntity(t, true);
			
		} catch (RuntimeException e) {
			logger.error(e);
			throw new SportsServiceException("Internal error getting tournament matchs info.");
		}
		
		return tournamentDto;
	}
	
	@Override
	@Transactional
	public MatchDto getMatchEvents(Long matchId) throws SportsServiceException {
		
		MatchDto matchDto = null;
		try{
			logger.debug("Buscando Match con Id: " + matchId);
			Match m = dao.getById(Match.class, matchId);
			if (m == null) {
				throw new SportsServiceException("Match not found with id " + matchId);
			}
			
			logger.debug("Match encontrado con Id: " + matchId);
			matchDto = getMatchDtoFromEntity(m, true);
			
		} catch (RuntimeException e) {
			logger.error(e);
			throw new SportsServiceException("Internal error getting match info.");
		}
		
		return matchDto;
	}
	

	/**
	 * Get the tournament Dto from the table entities.
	 * 
	 * @param tournaments
	 *            entities found.
	 * @param addMatchs
	 * @return tournament dto list. empty not null list if no tournaments are
	 *         found.
	 */
	private TournamentsDto getTournamentsFromEntities(
			List<Tournament> tournaments, boolean addMatchs) {
		TournamentsDto tournamentsDto = new TournamentsDto();

		for (Tournament t : tournaments) {
			TournamentDto tDto = getTournamentDtoFromEntity(t, addMatchs);
			tournamentsDto.getTournamentList().add(tDto);
		}

		return tournamentsDto;
	}

	/**
	 * Gets a tournamentDto from a tournament entity
	 * 
	 * @param t
	 *            tournament entity
	 * @param addMatchs
	 *            defines if match info is added to the tournaments
	 * @return tournament Dto
	 */
	private TournamentDto getTournamentDtoFromEntity(Tournament t,
			boolean addMatchs) {

		TournamentDto tDto = new TournamentDto();
		tDto.setId(t.getId());
		tDto.setName(t.getName());

		SimpleDateFormat sdf = new SimpleDateFormat(DATE_PATTERN);

		tDto.setInitDate(sdf.format(t.getInitDate()));
		tDto.setEndDate(sdf.format(t.getEndDate()));

		for (Group group : t.getGroups()) {
			GroupDto groupDto = getGroupDtoFromEntity(group, addMatchs);
			tDto.getGroups().add(groupDto);
		}

		tDto.setTournamentTypeDto(getTournamentTypeDtoFromEntity(t
				.getTournamentType()));

		return tDto;
	}

	private GroupDto getGroupDtoFromEntity(Group group, boolean addMatchs) {
		GroupDto gDto = new GroupDto();
		gDto.setName(group.getName());

		if (addMatchs) {
			for (Match m : group.getMatchs()) {
				gDto.getMatchList().add(getMatchDtoFromEntity(m, false));
			}
		}

		return gDto;
	}

	private MatchDto getMatchDtoFromEntity(Match m, boolean addEvents) {

		SimpleDateFormat sdf = new SimpleDateFormat(DATETIME_PATTERN);

		MatchDto mDto = new MatchDto();
		mDto.setId(m.getId());
		mDto.setDatetime(sdf.format(m.getDatetime()));
		mDto.setPlaceDto(getPlaceDtoFromEntity(m.getPlace()));
		mDto.setTeam1(getTeamDtoFromEntity(m.getTeam1()));
		mDto.setTeam2(getTeamDtoFromEntity(m.getTeam2()));
		mDto.setScoreTeam1(m.getScoreTeam1());
		mDto.setScoreTeam2(m.getScoreTeam2());
		mDto.setScoreTypeDto(getScoreTypeDtoFromEntity(m.getScoreType()));

		if (addEvents) {
			for (Event e : m.getEvents()) {
				mDto.getEventList().add(getEventDtoFromEntity(e));
			}
		}

		return mDto;
	}

	private ScoreTypeDto getScoreTypeDtoFromEntity(ScoreType scoreType) {
		ScoreTypeDto stDto = new ScoreTypeDto();
		stDto.setId(scoreType.getId());
		stDto.setName(scoreType.getName());
		return stDto;
	}

	private EventDto getEventDtoFromEntity(Event e) {
		EventDto eDto = new EventDto();
		eDto.setDescription(e.getDescription());
		eDto.setEventTypeDto(getEventTypeDtoFromEntity(e.getEventType()));
		eDto.setId(e.getId());
		eDto.setMinute(e.getMinute());
		eDto.setPeriod(e.getPeriod());
		
		return eDto;		
	}

	private EventTypeDto getEventTypeDtoFromEntity(EventType eventType) {
		EventTypeDto etDto = new EventTypeDto();
		etDto.setId(eventType.getId());
		etDto.setName(eventType.getName());
		return etDto;
	}

	private TeamDto getTeamDtoFromEntity(Team team) {

		TeamDto tDto = new TeamDto();
		tDto.setName(team.getName());
		return tDto;
	}

	private PlaceDto getPlaceDtoFromEntity(Place place) {
		PlaceDto pDto = new PlaceDto();
		pDto.setName(place.getName());
		return pDto;
	}

	private TournamentTypeDto getTournamentTypeDtoFromEntity(
			TournamentType tournamentType) {
		TournamentTypeDto ttDto = new TournamentTypeDto();
		ttDto.setName(tournamentType.getName());
		return ttDto;
	}



}

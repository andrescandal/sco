package com.ac.sco.sportsservice.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = { "id", "tournamentTypeDto", "name", "initDate", "endDate", "groups" })
@XmlAccessorType(XmlAccessType.FIELD)
public class TournamentDto {

	/**
	 * Tournament Id.
	 */
    private Long id;
    
    /**
     * TournamentType
     */
    private TournamentTypeDto tournamentTypeDto;
 
    /**
     * Tournament name
     */
    private String name;
    
    /**
     * Init date MM/dd/YYYY format
     */
    private String initDate;
    
    /**
     * End date MM/dd/YYYY format
     */
    private String endDate;
     
    /**
     * Groups in the tournament, Might be only one group.
     */
    @XmlElementWrapper(name="groups")
	@XmlElement(name="group")
    private List<GroupDto> groups = new ArrayList<GroupDto>();
    
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
	 * @return the tournamentTypeDto
	 */
	public TournamentTypeDto getTournamentTypeDto() {
		return tournamentTypeDto;
	}

	/**
	 * @param tournamentTypeDto the tournamentTypeDto to set
	 */
	public void setTournamentTypeDto(TournamentTypeDto tournamentTypeDto) {
		this.tournamentTypeDto = tournamentTypeDto;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the groups
	 */
	public List<GroupDto> getGroups() {
		return groups;
	}

	/**
	 * @param groups the groups to set
	 */
	public void setGroups(List<GroupDto> groups) {
		this.groups = groups;
	}
	
	/**
	 * @return the initDate
	 */
	public String getInitDate() {
		return initDate;
	}

	/**
	 * @param initDate the initDate to set
	 */
	public void setInitDate(String initDate) {
		this.initDate = initDate;
	}

	/**
	 * @return the endDate
	 */
	public String getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    
	
}

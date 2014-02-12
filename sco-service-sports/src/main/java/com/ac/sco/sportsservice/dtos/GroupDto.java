package com.ac.sco.sportsservice.dtos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * GroupDto of matches, per group of teams, date, etc.
 * @author Gteolis
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class GroupDto {

	/**
	 * Group name
	 */
	private String name;
	
	/**
	 * List of matchs
	 */
	@XmlElementWrapper(name="matchs")
	@XmlElement(name="match")
	private List<MatchDto> matchList = new ArrayList<MatchDto>();

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

	public void setMatchList(List<MatchDto> matchList) {
		this.matchList = matchList;
	}

	public List<MatchDto> getMatchList() {
		return matchList;
	}
	
}

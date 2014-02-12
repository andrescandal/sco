package com.ac.sco.sportsservice.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


@XmlType(propOrder = { "id", "eventTypeDto", "period", "minute", "description" })
@XmlAccessorType(XmlAccessType.FIELD)
public class EventDto {

    private Long id;
	
	private EventTypeDto eventTypeDto;
	
    private Integer period;
    
    private Integer minute;
        
    private String description;

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
	 * @return the eventTypeDto
	 */
	public EventTypeDto getEventTypeDto() {
		return eventTypeDto;
	}

	/**
	 * @param eventTypeDto the eventTypeDto to set
	 */
	public void setEventTypeDto(EventTypeDto eventTypeDto) {
		this.eventTypeDto = eventTypeDto;
	}

	/**
	 * @return the period
	 */
	public Integer getPeriod() {
		return period;
	}

	/**
	 * @param period the period to set
	 */
	public void setPeriod(Integer period) {
		this.period = period;
	}

	/**
	 * @return the minute
	 */
	public Integer getMinute() {
		return minute;
	}

	/**
	 * @param minute the minute to set
	 */
	public void setMinute(Integer minute) {
		this.minute = minute;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	
}

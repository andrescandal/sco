package com.ac.sco.sportsservice.domain;

import java.util.Collection;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

 
@Entity
public class Tournament {
 
    @Id 
    @GeneratedValue
    private Long id;
    
    @ManyToOne(optional=false) 
    private TournamentType tournamentType;
 
    @Column(length=40) 
    private String name;
    
    @Column
    private Date initDate;
    
    @Column
    private Date endDate;
     
    @OneToMany(mappedBy="tournament", cascade=CascadeType.REMOVE, fetch=FetchType.EAGER)
    private Collection<Group> groups;
    
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

	public void setInitDate(Date initDate) {
		this.initDate = initDate;
	}

	public Date getInitDate() {
		return initDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getEndDate() {
		return endDate;
	}


	public void setTournamentType(TournamentType tournamentType) {
		this.tournamentType = tournamentType;
	}

	public TournamentType getTournamentType() {
		return tournamentType;
	}

	public void setGroups(Collection<Group> groups) {
		this.groups = groups;
	}

	public Collection<Group> getGroups() {
		return groups;
	}
 
}
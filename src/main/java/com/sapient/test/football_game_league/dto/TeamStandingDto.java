package com.sapient.test.football_game_league.dto;

import com.sapient.test.football_game_league.model.TeamStanding;
import java.util.Objects;
import lombok.Data;

@Data
public class TeamStandingDto {

	private String country;
	private String league;
	private String team;
	private int overallPosition;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getLeague() {
		return league;
	}

	public void setLeague(String league) {
		this.league = league;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getOverallPosition() {
		return overallPosition;
	}

	public void setOverallPosition(int overallPosition) {
		this.overallPosition = overallPosition;
	}

	public static TeamStandingDto from(TeamStanding teamStanding) {
		TeamStandingDto dto = new TeamStandingDto();
		if (Objects.nonNull(teamStanding)) {
			dto.setCountry("(" + teamStanding.getCountryId() + ") - " + teamStanding.getCountryName());
			dto.setLeague("(" + teamStanding.getLeagueId() + ") - " + teamStanding.getLeagueName());
			dto.setTeam("(" + teamStanding.getTeamId() + ") - " + teamStanding.getTeamName());
			dto.setOverallPosition(teamStanding.getOverallPosition());
		}
		return dto;

	}
}

package us.data.nba.service;

import us.data.nba.entity.Team;

import java.util.List;

public interface TeamService {
    int registTeam(Team team);
    int deleteTeamById(Integer id);
    List<Team> showTeamInfoByName(String name);
    int updateTeamInfo(Team team);
}

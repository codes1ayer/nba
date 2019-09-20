package us.data.nba.service.impl;

import org.springframework.stereotype.Service;
import us.data.nba.entity.Team;
import us.data.nba.mapper.TeamMapper;
import us.data.nba.service.TeamService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TeamServiceimpl implements TeamService {

    @Resource
    TeamMapper teamMapper;

    @Override
    public int registTeam(Team team) {
        return teamMapper.insertSelective(team);
    }

    @Override
    public int deleteTeamById(Integer id) {
        return teamMapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<Team> showTeamInfoByName(String name) {
        return teamMapper.selectByPrimaryKey(name);
    }

    @Override
    public int updateTeamInfo(Team team) {
        return teamMapper.updateByPrimaryKeySelective(team);
    }
}

package us.data.nba.service.impl;

import org.springframework.stereotype.Service;
import us.data.nba.entity.Player;
import us.data.nba.entity.ShowTeam;
import us.data.nba.entity.Team;
import us.data.nba.entity.Teaminfo;
import us.data.nba.mapper.TeamMapper;
import us.data.nba.mapper.TeaminfoMapper;
import us.data.nba.service.TeamInfoService;

import javax.annotation.Resource;
import java.sql.Date;
import java.util.List;

@Service
public class TeamInfoServiceimpl implements TeamInfoService {

    @Resource
    TeaminfoMapper teaminfoMapper;

    @Override
    public int rigistPlayerInTeam(Teaminfo teaminfo) {
        return teaminfoMapper.insertSelective(teaminfo);
    }

    @Override
    public int updatePlayerContract(Teaminfo teaminfo) {
        return teaminfoMapper.updateByPrimaryKeySelective(teaminfo);
    }

    @Override
    public List<ShowTeam> showTeam(String name) {

        return teaminfoMapper.showTeam(name);
    }

    @Override
    public int deleteRecordByPlayerId(Integer id) {
        return teaminfoMapper.deleteByPrimaryKey(id);
    }
}

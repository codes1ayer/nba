package us.data.nba.service;

import us.data.nba.entity.ShowTeam;
import us.data.nba.entity.Teaminfo;

import java.sql.Date;
import java.util.List;

public interface TeamInfoService {

    int rigistPlayerInTeam(Teaminfo teaminfo);
    int updatePlayerContract(Teaminfo teaminfo);
    List<ShowTeam> showTeam(String Name);
    int deleteRecordByPlayerId(Integer id);
}

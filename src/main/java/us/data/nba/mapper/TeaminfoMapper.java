package us.data.nba.mapper;

import org.apache.ibatis.annotations.Mapper;
import us.data.nba.entity.Player;
import us.data.nba.entity.ShowTeam;
import us.data.nba.entity.Teaminfo;

import java.util.List;

@Mapper
public interface TeaminfoMapper {
    int deleteByPrimaryKey(int id);

    int insert(Teaminfo record);

    int insertSelective(Teaminfo record);

    Teaminfo selectByPrimaryKey(int id);

    int updateByPrimaryKeySelective(Teaminfo record);

    int updateByPrimaryKey(Teaminfo record);

    List<ShowTeam> showTeam(String name);
}

package us.data.nba.mapper;


import org.apache.ibatis.annotations.Mapper;
import us.data.nba.entity.Team;

import java.util.List;

@Mapper
public interface TeamMapper {
    int deleteByPrimaryKey(Integer teamid);

    int insert(Team record);

    int insertSelective(Team record);

    List<Team> selectByPrimaryKey(String name);

    int updateByPrimaryKeySelective(Team record);

    int updateByPrimaryKey(Team record);

}

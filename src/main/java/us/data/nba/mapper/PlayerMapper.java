package us.data.nba.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import us.data.nba.entity.Player;

import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface PlayerMapper {

    int deleteByPrimaryKey(Integer id);

    int deleteByName(String name);

    int insert(Player record);

    int insertSelective(Player record);

    Player selectByPrimaryKey(Integer id);

    List<Player> selectByName(String name);

    int updateByPrimaryKeySelective(Player record);

    int updateByPrimaryKey(Player record);

}

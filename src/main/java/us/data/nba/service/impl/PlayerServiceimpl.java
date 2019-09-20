package us.data.nba.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import us.data.nba.entity.Player;
import us.data.nba.mapper.PlayerMapper;
import us.data.nba.service.PlayerService;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PlayerServiceimpl implements PlayerService {

    @Resource
    private  PlayerMapper playerMapper;

    @Override
    @Transactional
    public int registPlayer(Player player) {
        return playerMapper.insert(player);
    }

    @Override
    @Transactional
    public int deletePlayerById(int id) {
        return playerMapper.deleteByPrimaryKey(id);
    }

    @Override
    @Transactional
    public int deletePlayerByName(String name) {
        return playerMapper.deleteByName(name);
    }

    @Override
    public int UpdatePlayerByid(Player player) {
        return playerMapper.updateByPrimaryKeySelective(player);
    }

    @Override
    public List<Player> ViewPlayerList(String name) {
        List<Player> playerList=playerMapper.selectByName(name);
        return playerList;
    }

    @Override
    public Player SelectById(int id) {
        Player player=playerMapper.selectByPrimaryKey(id);
        return player;
    }
}

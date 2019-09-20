package us.data.nba.service;

import us.data.nba.entity.Player;

import java.sql.Date;
import java.util.List;

public interface PlayerService {
        int registPlayer(Player player);
        int deletePlayerById(int id);
        int deletePlayerByName(String name);
        int UpdatePlayerByid(Player player);
        List<Player> ViewPlayerList(String name);
        Player SelectById(int id);
}

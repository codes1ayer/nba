package us.data.nba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;
import us.data.nba.entity.Player;
import us.data.nba.entity.ResBean;
import us.data.nba.entity.Team;
import us.data.nba.service.TeamService;
import us.data.nba.service.impl.TeamServiceimpl;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/team")
public class TeamController {

    @Resource
    TeamServiceimpl teamServiceimpl;

    @PostMapping("/regist")
    private Object rigistTeam(@RequestBody Team team){

        if (team.getCreatedata()==null)
            return ResBean.error("缺少创建时间信息");
        if (team.getLocation()==null)
            return ResBean.error("缺少球队位置信息");
        if (team.getName()==null)
            return ResBean.error("缺少姓名信息");
        if (team.getNameofgym()==null)
            return ResBean.error("缺少球馆名字信息");

        int n = teamServiceimpl.registTeam(team);
        if (n==0)
            return ResBean.error("插入失败");
        else
            return ResBean.ok("插入成功");
    }

    @PostMapping("/deletebyid")
    private Object deleteTeamById(@RequestBody Player player){

        int n = teamServiceimpl.deleteTeamById(player.id);
        if (n==0)
            return ResBean.error("删除球队失败");
        else
            return ResBean.ok("删除球队成功");
    }

    @GetMapping("/search/{name}")
    private Object showTeamInfo(@PathVariable String name){

        List<Team> teams = teamServiceimpl.showTeamInfoByName(name);
        if (teams.isEmpty()==false)
            return teams;
        else
            return ResBean.error("查无此队");
    }

    @PostMapping("update")
    private Object updateTeamInfo(@RequestBody Team team){

        int n = teamServiceimpl.updateTeamInfo(team);
        if(n==0)
            return ResBean.error("修改失败");
        else
            return ResBean.ok("修改成功");
    }

}

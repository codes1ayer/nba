package us.data.nba.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import us.data.nba.entity.ResBean;
import us.data.nba.entity.ShowTeam;
import us.data.nba.entity.Teaminfo;
import us.data.nba.service.TeamInfoService;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/teaminfo")
public class TeamInfoController {
    @Resource
    TeamInfoService teamInfoService;

    @Autowired
    RedisTemplate<String,String> redisTemplate;

    @PostMapping("/regist")
    private Object registPlayerInTeam(@RequestBody Teaminfo teaminfo){
        int n = teamInfoService.rigistPlayerInTeam(teaminfo);

        if (n==0)
            return ResBean.error("注册失败");
        else
            return ResBean.ok("注册成功");
    }

    @PostMapping("/delete")
    private Object deleteInfoById(@RequestBody Teaminfo teaminfo){
        int n = teamInfoService.deleteRecordByPlayerId(teaminfo.getId());
        if (n==0)
            return ResBean.error("记录删除失败");
        else
            return ResBean.ok("删除成功");
    }

    @PostMapping("/show")
    private Object showTeam(@RequestBody ShowTeam showTeam){
        List<ShowTeam> showTeams = teamInfoService.showTeam(showTeam.teamName);
        System.out.println(showTeam.teamName);
        if (showTeams.isEmpty()==true)
            return ResBean.error("查询失败");
        else
        {
            for(ShowTeam s:showTeams){
                redisTemplate.opsForList().leftPush("Plays"+s.teamName,s.playerName);
            }
            return showTeams;
        }

    }
}

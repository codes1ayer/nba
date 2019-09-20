package us.data.nba.controller;


import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;
import us.data.nba.entity.Player;
import us.data.nba.entity.ResBean;
import us.data.nba.kafka.KafkaSender;
import us.data.nba.service.impl.PlayerServiceimpl;
import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;

@RestController
@RequestMapping("/player")
public class PlayerController {


    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private KafkaSender kafkaTemplate;

    @Resource(name= "playerServiceimpl")
    private PlayerServiceimpl playerServiceimpl;

    @PostMapping("/regist")
    public Object RigstPlayer(@RequestBody Player player){
        if (player.arme==null)
            return ResBean.error("缺少臂展信息");
        if (player.brith==null)
            return ResBean.error("缺少生日信息");
        if (player.height==null)
            return ResBean.error("缺少身高信息");
        if (player.name==null)
            return ResBean.error("缺少姓名信息");
        if (player.nationality==null)
            return ResBean.error("缺少国籍信息");
        if (player.weight==null)
            return ResBean.error("缺少体重信息");
        int n = playerServiceimpl.registPlayer(player);
        if(n!=0){
            System.out.println(player.toString());
            redisTemplate.opsForValue().set("Player"+player.name, JSON.toJSONString(player));
            kafkaTemplate.send("NBA","registplayerinfo:"+player.toString());
            return ResBean.ok("球员注册成功");
        }
        else
            return ResBean.error("球员注册失败");
    }


    @GetMapping("/search/{name}")
    public Object SearchPlayerByName(@PathVariable("name") String name){
        String playerinfo;
        playerinfo=redisTemplate.opsForValue().get("Player"+name);
        if(playerinfo==null) {
            List<Player> playerList = playerServiceimpl.ViewPlayerList(name);
            if (playerList.isEmpty()==false){
                for(Player info:playerList) {
                    redisTemplate.opsForValue().set("Player"+info.name,JSON.toJSONString(info));
                }
                return playerList;
            }else
                return ResBean.error("查无此人");
        }else {
            return playerinfo;
        }

    }

    @PostMapping("/deletebyid")
    public Object DeletePlayerById(@RequestBody Player player){
        int n = playerServiceimpl.deletePlayerById(player.id);
        if(n==0)
            return ResBean.error("此球员不存在");
        else
            return ResBean.ok("删除成功");

    }

    @PostMapping("/deletebyname")
    public Object DeletePlayerByName(@RequestBody Player player){
        int n = playerServiceimpl.deletePlayerByName(player.name);
        if(n==0)
            return ResBean.error("此球员不存在");
        else
            return ResBean.ok("删除成功");

    }

    @PostMapping("/update")
    public Object updatePlayerInfo(@RequestBody Player player){

        int n = playerServiceimpl.UpdatePlayerByid(player);
        if(n==0)
            return ResBean.error("修改失败");
        else
            return ResBean.ok("修改成功");

    }



}

package us.data.nba.entity;

import java.sql.Date;

public class Team {
    private Integer teamid;

    private String name;

    private Date createdata;

    public Team(Integer teamid, String name, Date createdata, String location, String nameofgym) {
        this.teamid = teamid;
        this.name = name;
        this.createdata = createdata;
        this.location = location;
        this.nameofgym = nameofgym;
    }
    public Team() { }

    private String location;

    private String nameofgym;

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Date getCreatedata() {
        return createdata;
    }

    public void setCreatedata(Date createdata) {
        this.createdata = createdata;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getNameofgym() {
        return nameofgym;
    }

    public void setNameofgym(String nameofgym) {
        this.nameofgym = nameofgym == null ? null : nameofgym.trim();
    }
}

package us.data.nba.entity;

import java.sql.Date;

public class Teaminfo {
    private Integer id;

    private Integer teamid;

    private Date cstart;

    private Date cend;

    public Teaminfo(Integer id, Integer teamid, Date cstart, Date cend, Integer salary, Double avgscore, Double avgbackboard, Double avgassists) {
        this.id = id;
        this.teamid = teamid;
        this.cstart = cstart;
        this.cend = cend;
        this.salary = salary;
        this.avgscore = avgscore;
        this.avgbackboard = avgbackboard;
        this.avgassists = avgassists;
    }

    public Teaminfo() {
    }

    private Integer salary;

    private Double avgscore;

    private Double avgbackboard;

    private Double avgassists;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public Date getCstart() {
        return cstart;
    }

    public void setCstart(Date cstart) {
        this.cstart = cstart;
    }

    public Date getCend() {
        return cend;
    }

    public void setCend(Date cend) {
        this.cend = cend;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Double getAvgscore() {
        return avgscore;
    }

    public void setAvgscore(Double avgscore) {
        this.avgscore = avgscore;
    }

    public Double getAvgbackboard() {
        return avgbackboard;
    }

    public void setAvgbackboard(Double avgbackboard) {
        this.avgbackboard = avgbackboard;
    }

    public Double getAvgassists() {
        return avgassists;
    }

    public void setAvgassists(Double avgassists) {
        this.avgassists = avgassists;
    }
}
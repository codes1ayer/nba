package us.data.nba.entity;

public class ShowTeam {
    public String playerName;
    public String teamName;

    public ShowTeam(String playerName, String teamName) {
        this.playerName = playerName;
        this.teamName = teamName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}

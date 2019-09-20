package at.htl.football;

import java.util.*;

public class League {

    public static List<Team> teams = new ArrayList();

    public static void addMatchResult(Match match) {
        findOrCreateTeam(match.getHomeName()).addMatch(match);
        findOrCreateTeam(match.getGuestName()).addMatch(match);
    }

    protected static Team findOrCreateTeam(String teamName) {
        for (Team team : teams) {
            if (team.getName().equals(teamName)) {
                return team;
            }
        }

        Team team = new Team(teamName);
        teams.add(team);
        return team;
    }

    public static List<Team> getTable() {
        teams.sort(Collections.reverseOrder());
        return teams;
    }
}
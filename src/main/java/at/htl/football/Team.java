package at.htl.football;

public class Team implements Comparable<Team> {
    private String name;
    int points;
    private int wins;
    private int draws;
    private int defeats;
    private int goalsShot;
    private int goalsReceived;

    public Team(String name) {
        this.name = name;
    }

    public void addMatch(Match match) {
        if (match.getHomeName().equals(name)) {
            points += match.getHomePoints();
            goalsShot += match.getHomeGoals();
            goalsReceived += match.getGuestGoals();

            switch (match.getHomePoints()) {
                case 3:
                    wins++;
                    break;
                case 1:
                    draws++;
                    break;
                case 0:
                    defeats++;
            }
        } else if (match.getGuestName().equals(name)) {
            points += match.getGuestPoints();
            goalsShot += match.getGuestGoals();
            goalsReceived += match.getHomeGoals();

            switch (match.getGuestPoints()) {
                case 3:
                    wins++;
                    break;
                case 1:
                    draws++;
                    break;
                case 0:
                    defeats++;
            }
        }
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getDefeats() {
        return defeats;
    }

    public int getGoalsShot() {
        return goalsShot;
    }

    public int getGoalsReceived() {
        return goalsReceived;
    }

    public int getGoalDifference() {
        return getGoalsShot() - getGoalsReceived();
    }

    @Override
    public int compareTo(Team team) {
        if (points > team.getPoints()) {
            return 1;
        } else if (points < team.getPoints()) {
            return -1;
        } else {
            return Integer.compare(getGoalDifference(), team.getGoalDifference());
        }
    }
}
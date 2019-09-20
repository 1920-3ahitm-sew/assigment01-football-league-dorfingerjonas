package at.htl.football;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        readFile();
        printTable(League.getTable());
    }

    private static void readFile() {
        List<String> file;

        try {
            file = Files.readAllLines(Paths.get("bundesliga-1819.csv"));

            int i = 0;

            for (String match : file) {
                if (i > 0) {
                    String homeTeam;
                    String guestTeam;
                    int homeGoals;
                    int guestGoals;

                    String[] parts = match.split(";");

                    homeTeam = parts[1];
                    guestTeam = parts[2];
                    homeGoals = Integer.parseInt(parts[3]);
                    guestGoals = Integer.parseInt(parts[4]);

                    League.addMatchResult(new Match(homeTeam, guestTeam, homeGoals, guestGoals));
                }
                i++;
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private static void printTable(List<Team> teams) {
        System.out.printf("%-23s%5s%5s%5s%5s%5s%5s%5s%n", "Team", "Pts", 'W', 'D', 'L', "GF", "GA", "GD");

        for (Team team : teams) {
            System.out.printf("%-23s%5d%5d%5d%5d%5d%5d%5d%n", team.getName(), team.getPoints(), team.getWins(), team.getDraws(), team.getDefeats(), team.getGoalsShot(), team.getGoalsReceived(), team.getGoalDifference());
        }

        System.out.println("\n\nPts...Points, W...Won, D...Drawn, L...Lost\n" + "GF...Goals for, GA...Goals against, GD...Goal difference");
    }
}
package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class LeagueTest {

    @Test
    public void addMatchResult() {
        League.addMatchResult(new Match("Bayern Munich", "Hoffenheim", 3,1));

        assertThat(League.teams.get(0).getName(), is("Bayern Munich"));
        assertThat(League.teams.get(1).getName(), is("Hoffenheim"));
    }

    @Test
    void test_League_addMatchResults() {
        League.addMatchResult(new Match("homeTeam", "guestTeam", 5, 7));

        assertThat(League.teams.get(0).getName(), is("guestTeam"));
        assertThat(League.teams.get(1).getName(), is("homeTeam"));
    }

    @Test
    void test_League_findOrCreateTeam_findExisting() {
        League.teams.add(new Team("team1"));
        League.teams.add(new Team("team2"));

        assertThat(League.findOrCreateTeam("team1").getName(), is("team1"));
        assertThat(League.findOrCreateTeam("team2").getName(), is("team2"));
    }

    @Test
    void test_Leaugue_findOrCreateTeam_createNew() {

        League.findOrCreateTeam("team1");
        League.findOrCreateTeam("team2");

        assertThat(League.findOrCreateTeam("team1").getName(), is("team1"));
        assertThat(League.findOrCreateTeam("team2").getName(), is("team2"));
    }
}
package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class TeamTest {

    @Test
    void test_Team_compareTo_lessThan() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");

        team1.points = 10;
        team2.points = 5;

        assertThat(team2.compareTo(team1), lessThan(0));
    }

    @Test
    void test_Team_compareTo_greaterThan() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");

        team1.points = 10;
        team2.points = 5;

        assertThat(team1.compareTo(team2), greaterThan(0));
    }

    @Test
    void test_Team_compareTo_equal_points() {
        Team team1 = new Team("Bayern Munich");
        Team team2 = new Team("Hoffenheim");

        team1.points = 10;
        team2.points = 10;

        assertThat(team1.compareTo(team2), is(0));
    }
}
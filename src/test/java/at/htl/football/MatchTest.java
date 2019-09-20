package at.htl.football;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

@TestMethodOrder(MethodOrderer.Alphanumeric.class)
class MatchTest {

    @Test
    public void guest_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 2, 4);

        assertThat(match.getGuestPoints(), is(3));
        assertThat(match.getHomePoints(), is(0));
    }

    @Test
    public void home_team_wins() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 4, 2);

        assertThat(match.getGuestPoints(), is(0));
        assertThat(match.getHomePoints(), is(3));
    }

    @Test
    public void draw() {
        Match match = new Match("Bayern Munich", "Hoffenheim", 2, 2);

        assertThat(match.getGuestPoints(), is(1));
        assertThat(match.getHomePoints(), is(1));
    }
}
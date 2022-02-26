package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class StraightTest {
    @Test
    public void shouldReturnSameStraight2To6() throws Exception {
        HandType firstStraight = new Straight(TWO_CLUB, THREE_DIAMOND, FOUR_HEART, FIVE_SPADE, SIX_SPADE);
        HandType secondStraight = new Straight(TWO_HEART, THREE_DIAMOND, FOUR_HEART, FIVE_SPADE, SIX_SPADE);
        int ordinal = firstStraight.compareTo(secondStraight);
        assertEquals(0, ordinal);
    }

    @Test
    public void twoTo6StraightShouldBeLower3To7() throws Exception {
        HandType firstStraight = new Straight(TWO_CLUB, THREE_DIAMOND, FOUR_HEART, FIVE_SPADE, SIX_SPADE);
        HandType secondStraight = new Straight(THREE_DIAMOND, FOUR_HEART, FIVE_SPADE, SIX_SPADE, SEVEN_CLUB);
        int ordinal = firstStraight.compareTo(secondStraight);
        assertEquals(-1, ordinal);
    }

    @Test
    public void twoTo6StraightShouldBeHigherAceTo5() throws Exception {
        HandType firstStraight = new Straight(TWO_CLUB, THREE_DIAMOND, FOUR_HEART, FIVE_SPADE, SIX_SPADE);
        HandType secondStraight = new Straight(ACE_CLUB, TWO_DIAMOND, THREE_DIAMOND, FOUR_HEART, FIVE_SPADE);
        int ordinal = firstStraight.compareTo(secondStraight);
        assertEquals(1, ordinal);
    }
}

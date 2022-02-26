package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class FullHouseTest {
    @Test
    public void shouldReturnSameFullHouse() throws Exception {
        HandType firstFullHouse = new FullHouse(TWO_HEART, TWO_CLUB, TWO_DIAMOND, SEVEN_CLUB, SEVEN_DIAMOND);
        HandType secondFullHouse = new FullHouse(TWO_HEART, TWO_CLUB, TWO_DIAMOND, SEVEN_CLUB, SEVEN_DIAMOND);
        int ordinal = firstFullHouse.compareTo(secondFullHouse);
        assertEquals(0, ordinal);
    }

    @Test
    public void three3sShouldBeHigherThan32s() throws Exception {
        HandType threethree = new FullHouse(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SEVEN_CLUB, SEVEN_DIAMOND);
        HandType three2s = new FullHouse(TWO_HEART, TWO_CLUB, TWO_DIAMOND, SEVEN_CLUB, SEVEN_DIAMOND);
        int ordinal = threethree.compareTo(three2s);
        assertEquals(1, ordinal);
    }

    @Test
    public void sevenPairKickerShouldBeHigherThan6PairKicker() throws Exception {
        HandType sevenPairKicker = new FullHouse(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SEVEN_CLUB, SEVEN_DIAMOND);
        HandType sixPairKicker = new FullHouse(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SIX_CLUB, SIX_DIAMOND);
        int ordinal = sevenPairKicker.compareTo(sixPairKicker);
        assertEquals(1, ordinal);
    }
}

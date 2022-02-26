package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class FourOfAKindTest {

    @Test
    public void shouldReturnSameFourOfAKind() throws Exception {
        HandType firstFour2s = new FourOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, TWO_SPADE, SIX_SPADE);
        HandType secondFour2s = new FourOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, TWO_SPADE, SIX_SPADE);
        int ordinal = firstFour2s.compareTo(secondFour2s);
        assertEquals(0, ordinal);
    }

    @Test
    public void three4sShouldBeHigherThan42s() throws Exception {
        HandType threeFours = new FourOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, THREE_SPADE, SIX_SPADE);
        HandType secondFour2s = new FourOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, TWO_SPADE, SIX_SPADE);
        int ordinal = threeFours.compareTo(secondFour2s);
        assertEquals(1, ordinal);
    }

    @Test
    public void tenKickerShouldBeHigherThanNiceKicker() throws Exception {
        HandType firstFourOfAKind = new FourOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, THREE_SPADE, TEN_SPADE);
        HandType secondFourOfAKind = new FourOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, THREE_SPADE, NINE_HEART);
        int ordinal = firstFourOfAKind.compareTo(secondFourOfAKind);
        assertEquals(1, ordinal);
    }
}

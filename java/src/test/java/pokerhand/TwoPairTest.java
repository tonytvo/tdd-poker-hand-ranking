package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class TwoPairTest {
    @Test
    public void pairOf2sShouldReturnSame() throws Exception {
        HandType firstHandType = new TwoPair(JACK_CLUB, SIX_CLUB, SIX_HEART, TWO_HEART, TWO_DIAMOND);
        HandType secondHandType = new TwoPair(JACK_HEART, SIX_DIAMOND, SIX_SPADE, TWO_CLUB, TWO_SPADE);
        int ordinal = firstHandType.compareTo(secondHandType);
        assertEquals(0, ordinal);
    }

    @Test
    public void pairSevenKickerShouldReturnHigherPairSixKicker() throws Exception {
        HandType pairSevenKicker = new TwoPair(JACK_CLUB, SEVEN_CLUB, SEVEN_HEART, TWO_HEART, TWO_DIAMOND);
        HandType pairSixKickerHandType = new TwoPair(JACK_HEART, SIX_DIAMOND, SIX_SPADE, TWO_CLUB, TWO_SPADE);
        int ordinal = pairSevenKicker.compareTo(pairSixKickerHandType);
        assertEquals(1, ordinal);
    }

    @Test
    public void jackKickerShouldReturnHigherTenKicker() throws Exception {
        HandType pairSevenKicker = new TwoPair(JACK_CLUB, SEVEN_CLUB, SEVEN_HEART, TWO_HEART, TWO_DIAMOND);
        HandType pairSixKickerHandType = new TwoPair(TEN_SPADE, TWO_CLUB, TWO_SPADE, SEVEN_DIAMOND, SEVEN_SPADE);
        int ordinal = pairSevenKicker.compareTo(pairSixKickerHandType);
        assertEquals(1, ordinal);
    }
}

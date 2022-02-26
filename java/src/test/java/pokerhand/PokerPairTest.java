package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class PokerPairTest {

    @Test
    public void pairOf2sShouldReturnSame() throws Exception {
        HandType firstHandType = new PokerPair(JACK_CLUB, EIGHT_DIAMOND, SIX_HEART, TWO_HEART, TWO_DIAMOND);
        HandType secondHandType = new PokerPair(JACK_HEART, EIGHT_HEART, SIX_SPADE, TWO_CLUB, TWO_SPADE);
        int ordinal = firstHandType.compareTo(secondHandType);
        assertEquals(0, ordinal);
    }

    @Test
    public void pairOf3sShouldHigherPairOf2s() throws Exception {
        HandType firstHandType = new PokerPair(JACK_CLUB, EIGHT_DIAMOND, SIX_HEART, THREE_CLUB, THREE_HEART);
        HandType secondHandType = new PokerPair(JACK_HEART, EIGHT_HEART, SIX_SPADE, TWO_CLUB, TWO_SPADE);
        int ordinal = firstHandType.compareTo(secondHandType);
        assertEquals(1, ordinal);
    }

    @Test
    public void pairOf2sWithHigherKickerShouldBeHigherPair() throws Exception {
        HandType firstHandType = new PokerPair(QUEEN_CLUB, EIGHT_DIAMOND, SIX_HEART, TWO_HEART, TWO_DIAMOND);
        HandType secondHandType = new PokerPair(JACK_HEART, EIGHT_HEART, SIX_SPADE, TWO_CLUB, TWO_SPADE);
        int ordinal = firstHandType.compareTo(secondHandType);
        assertEquals(1, ordinal);
    }

    @Test
    public void pairOf3sShouldBeHigherPairOf2s() throws Exception {
        HandType firstHand = new PokerPair(JACK_CLUB, EIGHT_DIAMOND, SIX_HEART, TWO_HEART, TWO_DIAMOND);
        HandType secondHand = new PokerPair(EIGHT_DIAMOND, TEN_HEART, SIX_HEART, THREE_HEART, THREE_CLUB);
        int ordinal = firstHand.compareTo(secondHand);
        assertEquals(-1, ordinal, "pair of 3 should be higher than pair of 2");
    }
}

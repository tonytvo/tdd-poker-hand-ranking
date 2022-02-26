package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class StraightFlushTest {

    @Test
    public void aceHighStraightFlushShouldBeHigherThanKingHighStraightFlush() throws Exception {
        HandType aceStraightFlush = new StraightFlush(KING_CLUB, ACE_CLUB, QUEEN_CLUB, JACK_CLUB, TEN_CLUB);
        HandType kingStraightFlush = new StraightFlush(KING_HEART, QUEEN_HEART, JACK_HEART, TEN_HEART, NINE_HEART);
        int ordinal = aceStraightFlush.compareTo(kingStraightFlush);
        assertEquals(1, ordinal);
    }

    @Test
    public void aceHighStraightFlushShouldBeSameAsAceHighStraightFlush() throws Exception {
        HandType aceStraightFlush = new StraightFlush(KING_CLUB, ACE_CLUB, QUEEN_CLUB, JACK_CLUB, TEN_CLUB);
        HandType kingStraightFlush = new StraightFlush(KING_HEART, QUEEN_HEART, JACK_HEART, TEN_HEART, ACE_HEART);
        int ordinal = aceStraightFlush.compareTo(kingStraightFlush);
        assertEquals(0, ordinal);
    }
}

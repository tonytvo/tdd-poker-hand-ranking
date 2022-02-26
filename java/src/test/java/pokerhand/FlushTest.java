package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class FlushTest {
    @Test
    public void shouldReturnSameFlush() throws Exception {
        HandType firstHand = new Flush(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, EIGHT_DIAMOND);
        HandType secondHand = new Flush(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, EIGHT_DIAMOND);
        int ordinal = firstHand.compareTo(secondHand);
        assertEquals(0, ordinal);
    }

    @Test
    public void tenKickertFlushShouldBeHigherNineKickerFlush() throws Exception {
        HandType firstHand = new Flush(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, TEN_DIAMOND);
        HandType secondHand = new Flush(TWO_HEART, THREE_HEART, FOUR_HEART, FIVE_HEART, NINE_HEART);
        int ordinal = firstHand.compareTo(secondHand);
        assertEquals(1, ordinal);
    }
}

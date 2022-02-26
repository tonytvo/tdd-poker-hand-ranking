package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class HighCardTest {

    @Test
    public void ten8642KickerShouldBeSameAs810642() throws Exception {
        HandType firstHand = new HighCard(TEN_CLUB, EIGHT_DIAMOND, SIX_HEART, FOUR_SPADE, TWO_DIAMOND);
        HandType secondHand = new HighCard(EIGHT_DIAMOND, TEN_HEART, SIX_HEART, FOUR_SPADE, TWO_DIAMOND);
        int ordinal = firstHand.compareTo(secondHand);
        assertEquals(0, ordinal, "ten kicker should be eequals to 10 kicker");
    }
}

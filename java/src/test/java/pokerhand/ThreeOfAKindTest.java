package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 9/18/2016.
 */
public class ThreeOfAKindTest {
    @Test
    public void shouldReturnSameThreeOfAKind() {
        HandType firstThree2s = new ThreeOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, SEVEN_CLUB, SIX_SPADE);
        HandType secondThree2s = new ThreeOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, SEVEN_CLUB, SIX_SPADE);
        int ordinal = firstThree2s.compareTo(secondThree2s);
        assertEquals(0, ordinal);
    }

    @Test
    public void three3sShouldBeHigherThan32s() throws Exception {
        HandType threethree = new ThreeOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SEVEN_CLUB, SIX_SPADE);
        HandType three2s = new ThreeOfAKind(TWO_HEART, TWO_CLUB, TWO_DIAMOND, NINE_HEART, SIX_SPADE);
        int ordinal = threethree.compareTo(three2s);
        assertEquals(1, ordinal);
    }

    @Test
    public void nineKickerShouldBeHigherThan7Kicker() throws Exception {
        HandType threethree = new ThreeOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SEVEN_CLUB, SIX_SPADE);
        HandType three2s = new ThreeOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, NINE_HEART, SIX_SPADE);
        int ordinal = threethree.compareTo(three2s);
        assertTrue(ordinal < 0);
    }

    @Test
    public void sevenKickerShouldBeLowerThan9Kicker() throws Exception {
        HandType sevenKicker = new ThreeOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, SEVEN_CLUB, SIX_SPADE);
        HandType nineKicker = new ThreeOfAKind(THREE_CLUB, THREE_HEART, THREE_DIAMOND, NINE_HEART, SIX_SPADE);
        int ordinal = nineKicker.compareTo(sevenKicker);
        assertTrue(ordinal > 0);
    }
}

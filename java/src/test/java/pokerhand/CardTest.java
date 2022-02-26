package pokerhand;

import org.junit.jupiter.api.Test;
import pokerhand.model.Card;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Tony on 9/18/2016.
 */
public class CardTest {

    @Test
    public void threeClubShouldSameAs3Heart() throws Exception {
        int ordinal = Card.THREE_CLUB.compareTo(Card.THREE_DIAMOND);
        assertEquals(0, ordinal, "3 club should be ranked same as 3 diamond");
    }

    @Test
    public void threeClubShouldHigher2Heart() throws Exception {
        int ordinal = Card.THREE_CLUB.compareTo(Card.TWO_HEART);
        assertEquals(1, ordinal, "3 club should be ranked same as 3 diamond");
    }

    @Test
    public void threeClubShouldLower4Heart() throws Exception {
        int ordinal = Card.THREE_CLUB.compareTo(Card.FOUR_HEART);
        assertEquals(-1, ordinal, "3 club should be ranked same as 3 diamond");
    }
}

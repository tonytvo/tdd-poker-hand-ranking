package pokerhand;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pokerhand.model.Card.*;

/**
 * Created by Tony on 1/15/2016.
 */
public class PokerHandTest {

    @Test
    public void pairOf2sShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(JACK_CLUB, EIGHT_DIAMOND, SIX_HEART, TWO_HEART, TWO_DIAMOND);
        boolean hasPair = firstHand.hasPair();
        assertEquals(true, hasPair, "pair of 3 should be higher than pair of 2");
    }

    @Test
    public void twoTo6StraightShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, THREE_CLUB, FOUR_SPADE, FIVE_DIAMOND, SIX_HEART);
        boolean isStraight = firstHand.isStraight();
        assertEquals(true, isStraight);
    }

    @Test
    public void aceTo5StraightShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(ACE_CLUB, TWO_DIAMOND, THREE_CLUB, FOUR_SPADE, FIVE_DIAMOND);
        boolean isStraight = firstHand.isStraight();
        assertEquals(true, isStraight);
    }

    @Test
    public void straightShouldBeHigherThanHighCard() throws Exception {
        PokerHand straightHand = new PokerHand(TWO_DIAMOND, THREE_CLUB, FOUR_SPADE, FIVE_DIAMOND, SIX_HEART);
        PokerHand highCardHand = new PokerHand(JACK_CLUB, THREE_CLUB, FOUR_SPADE, FIVE_DIAMOND, SIX_HEART);
        int ordinal = straightHand.compareTo(highCardHand);
        assertEquals(1, ordinal);
    }

    @Test
    public void pairShouldBeLowerThanStraight() throws Exception {
        PokerHand straightHand = new PokerHand(TWO_DIAMOND, THREE_CLUB, FOUR_SPADE, FIVE_DIAMOND, SIX_HEART);
        PokerHand pairHand = new PokerHand(JACK_CLUB, THREE_CLUB, THREE_CLUB, FIVE_DIAMOND, SIX_HEART);
        int ordinal = pairHand.compareTo(straightHand);
        assertEquals(-1, ordinal);
    }

    @Test
    public void diamondFlushShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, EIGHT_DIAMOND);
        boolean isFlush = firstHand.isFlush();
        assertEquals(true, isFlush);
    }

    @Test
    public void diamondFlushShouldFlushHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, EIGHT_DIAMOND);
        HandType flushHandType = firstHand.getHandType();
        assertTrue(flushHandType instanceof Flush);
    }

    @Test
    public void straightFlushShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, SIX_DIAMOND);
        boolean isStraightFlush = firstHand.isStraightFlush();
        assertEquals(true, isStraightFlush);
    }
    @Test
    public void straightFlushHandShouldReturnStraightFlushHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, THREE_DIAMOND, FOUR_DIAMOND, FIVE_DIAMOND, SIX_DIAMOND);
        HandType flushHandType = firstHand.getHandType();
        assertTrue(flushHandType instanceof StraightFlush);
    }

    @Test
    public void fourOfAKindShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_HEART, TWO_SPADE, TWO_CLUB, SIX_DIAMOND);
        boolean isFourOfAKind = firstHand.isFourOfAKind();
        assertEquals(true, isFourOfAKind);
    }

    @Test
    public void fourOfAKindHandShouldReturnFourOfAKindHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_CLUB, TWO_SPADE, TWO_HEART, SIX_DIAMOND);
        HandType fourOfAKind = firstHand.getHandType();
        assertTrue(fourOfAKind instanceof FourOfAKind);
    }

    @Test
    public void threeOfAKindShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_HEART, TWO_SPADE, SEVEN_CLUB, SIX_DIAMOND);
        boolean isThreeOfAKind = firstHand.isThreeOfAKind();
        assertEquals(true, isThreeOfAKind);
    }

    @Test
    public void threeOfAKindHandShouldReturnFourOfAKindHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_CLUB, TWO_SPADE, SEVEN_CLUB, SIX_DIAMOND);
        HandType threeOfAKind = firstHand.getHandType();
        assertTrue(threeOfAKind instanceof ThreeOfAKind);
    }

    @Test
    public void fullHouseShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_HEART, TWO_SPADE, SEVEN_CLUB, SEVEN_DIAMOND);
        boolean isFullHouse = firstHand.isFullHouse();
        assertEquals(true, isFullHouse);
    }

    @Test
    public void twoPairsShouldReturnTrue() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_HEART, TEN_HEART, SEVEN_CLUB, SEVEN_DIAMOND);
        boolean hasTwoPairs = firstHand.hasTwoPairs();
        assertEquals(true, hasTwoPairs);
    }

    @Test
    public void fullHouseHandShouldReturnFullHouseHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_CLUB, TWO_SPADE, SEVEN_CLUB, SEVEN_DIAMOND);
        HandType fullHouseType = firstHand.getHandType();
        assertTrue(fullHouseType instanceof FullHouse);
    }

    @Test
    public void twoPairsHouseHandShouldReturnTwoPairsHandType() throws Exception {
        PokerHand firstHand = new PokerHand(TWO_DIAMOND, TWO_CLUB, TEN_HEART, SEVEN_CLUB, SEVEN_DIAMOND);
        HandType twoPairsType = firstHand.getHandType();
        assertTrue(twoPairsType instanceof TwoPair);
    }


}

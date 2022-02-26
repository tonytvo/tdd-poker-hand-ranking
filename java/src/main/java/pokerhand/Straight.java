package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class Straight implements HandType {

    private final List<Card> cards;

    public Straight(List<Card> pokerCards) {
        this.cards = new ArrayList<>(pokerCards);
    }

    public Straight(Card... pokerCards) {
        this.cards = asList(pokerCards);
    }

    @Override
    public int compareTo(HandType o) {
        Card thisHighestCard = getHighestStraightCard();
        Card thatHighestCard = ((Straight) o).getHighestStraightCard();
        return thisHighestCard.compareTo(thatHighestCard);
    }

    private Card getHighestStraightCard() {
        List<Card> thisSortedCards = new ArrayList<>(cards);
        Collections.sort(thisSortedCards, Collections.reverseOrder());
        if (isLowerAceStraight(thisSortedCards)) {
            return thisSortedCards.get(1);
        }
        return thisSortedCards.get(0);
    }

    private boolean isLowerAceStraight(List<Card> thisSortedCards) {
        return Math.abs(thisSortedCards.get(0).getRank().getValue() - thisSortedCards.get(1).getRank().getValue()) == 9;
    }

    @Override
    public int getHandTypeOrdinal() {
        return 5;
    }
}

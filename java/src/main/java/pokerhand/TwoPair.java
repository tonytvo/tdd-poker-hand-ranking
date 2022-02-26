package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class TwoPair implements HandType {
    private final List<Card> cards;

    public TwoPair(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public TwoPair(Card... cards) {
        this.cards = asList(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 3;
    }

    @Override
    public int compareTo(HandType o) {
        return CardUtils.compareCardsBasedOnMultipleRankCountCriteria(2, 1, this.cards, ((TwoPair) o).cards);
    }
}

package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class FourOfAKind implements HandType {
    private final List<Card> cards;

    public FourOfAKind(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public FourOfAKind(Card... cards) {
        this.cards = asList(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 8;
    }

    @Override
    public int compareTo(HandType o) {
        return CardUtils.compareCardsBasedOnMultipleRankCountCriteria(4, 1, this.cards, ((FourOfAKind) o).cards);
    }
}

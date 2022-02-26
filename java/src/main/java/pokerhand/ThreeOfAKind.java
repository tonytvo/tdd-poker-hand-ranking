package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class ThreeOfAKind implements HandType {
    private final List<Card> cards;

    public ThreeOfAKind(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public ThreeOfAKind(Card... cards) {
        this.cards = asList(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 4;
    }

    @Override
    public int compareTo(HandType o) {
        return CardUtils.compareCardsBasedOnMultipleRankCountCriteria(3, 1, this.cards, ((ThreeOfAKind) o).cards);
    }
}

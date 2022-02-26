package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class PokerPair implements HandType {
    private final List<Card> cards;

    public PokerPair(List<Card> pokerCards) {
        this.cards = new ArrayList<>(pokerCards);
    }

    public PokerPair(Card... pokerCards) {
        this.cards = asList(pokerCards);
    }

    @Override
    public int compareTo(HandType o) {
        return CardUtils.compareCardsBasedOnMultipleRankCountCriteria(2, 1, this.cards, ((PokerPair) o).cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 2;
    }
}

package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class FullHouse implements HandType {
    private final List<Card> cards;

    public FullHouse(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public FullHouse(Card... cards) {
        this.cards = asList(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 7;
    }

    @Override
    public int compareTo(HandType o) {
        return CardUtils.compareCardsBasedOnMultipleRankCountCriteria(3, 2, this.cards, ((FullHouse) o).cards);
    }
}

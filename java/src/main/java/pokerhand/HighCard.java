package pokerhand;

import pokerhand.model.Card;
import pokerhand.model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class HighCard implements HandType {

    private final List<Card> cards;

    public HighCard(List<Card> pokerCards) {
        this.cards = new ArrayList<>(pokerCards);
    }

    public HighCard(Card... pokerCards) {
        this.cards = asList(pokerCards);
    }

    @Override
    public int compareTo(HandType otherHandType) {
        return CompareUtils.compareComparables(cards, ((HighCard)otherHandType).cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 0;
    }


}

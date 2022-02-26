package pokerhand;

import pokerhand.model.Card;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static java.util.Arrays.asList;

/**
 * Created by Tony on 9/18/2016.
 */
public class Flush implements HandType {
    private final List<Card> cards;

    public Flush(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public Flush(Card... cards) {
        this.cards = asList(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 6;
    }

    @Override
    public int compareTo(HandType o) {
        return CompareUtils.compareComparables(cards, ((Flush)o).cards);
    }
}

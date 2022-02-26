package pokerhand;

import pokerhand.model.Card;

import java.util.List;

/**
 * Created by Tony on 9/18/2016.
 */
public class StraightFlush implements HandType {
    private final Straight straight;

    public StraightFlush(List<Card> cards) {
        this.straight = new Straight(cards);
    }

    public StraightFlush(Card... cards) {
        this.straight = new Straight(cards);
    }

    @Override
    public int getHandTypeOrdinal() {
        return 9;
    }

    @Override
    public int compareTo(HandType o) {
        return straight.compareTo(((StraightFlush) o).straight);
    }
}

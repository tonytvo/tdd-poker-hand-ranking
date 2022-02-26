package pokerhand;

import pokerhand.model.Card;
import pokerhand.model.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class PokerHand implements Comparable<PokerHand> {

    private final List<Card> cards;

    public PokerHand(Card... pokerCards) {
        this.cards = asList(pokerCards);
    }

    @Override
    public int compareTo(PokerHand otherHand) {
        HandType thisHandType = getHandType();
        HandType thatHandType = otherHand.getHandType();
        if (thisHandType.getHandTypeOrdinal() > thatHandType.getHandTypeOrdinal()) {
            return 1;
        }
        if (thisHandType.getHandTypeOrdinal() < thatHandType.getHandTypeOrdinal()) {
            return -1;
        }
        return thisHandType.compareTo(thatHandType);
    }

    protected HandType getHandType() {
        if (isStraightFlush()) {
            return new StraightFlush(cards);
        }
        if (isFourOfAKind()) {
            return new FourOfAKind(cards);
        }
        if (isFullHouse()) {
            return new FullHouse(cards);
        }
        if (isFlush()) {
            return new Flush(cards);
        }
        if (isStraight()) {
            return new Straight(cards);
        }
        if (isThreeOfAKind()) {
            return new ThreeOfAKind(cards);
        }
        if (hasTwoPairs()) {
            return new TwoPair(cards);
        }
        if (hasPair()) {
            return new PokerPair(cards);
        }
        return new HighCard(cards);
    }

    protected boolean hasPair() {
        return CardUtils.getRanksWithCount(cards, 2).size()==1;
    }

    public boolean isStraight() {
        List<Card> sortedCards = new ArrayList<>(cards);
        Collections.sort(sortedCards);

        Card prevCard = null;
        for (Card card: sortedCards) {
            if (prevCard == null) {
                prevCard = card;
                continue;
            }
            if (Math.abs(card.getRank().getValue() - prevCard.getRank().getValue()) == 9) {
                prevCard = card;
                continue;
            }
            if (Math.abs(card.getRank().getValue() - prevCard.getRank().getValue()) == 1) {
                prevCard = card;
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean isFlush() {
        Map<Suit, Long> suitCountMap = CardUtils.getSuitCountMap(cards);
        List<Suit> flushSuit = suitCountMap.entrySet().stream()
                .filter(map -> map.getValue() == 5)
                .map(map -> map.getKey())
                .collect(Collectors.toList());
        return flushSuit.size()==1;
    }

    public boolean isStraightFlush() {
        return isStraight() && isFlush();
    }

    public boolean isFourOfAKind() {
        return CardUtils.getRanksWithCount(this.cards, 4).size() == 1;
    }

    public boolean isThreeOfAKind() {
        return CardUtils.getRanksWithCount(this.cards, 3).size() == 1;
    }

    public boolean isFullHouse() {
        return isThreeOfAKind() && hasPair();
    }

    public boolean hasTwoPairs() {
        return CardUtils.getRanksWithCount(this.cards, 2).size() == 2;
    }
}

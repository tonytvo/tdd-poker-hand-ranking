package pokerhand;

import pokerhand.model.Card;
import pokerhand.model.Rank;
import pokerhand.model.Suit;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Tony on 9/18/2016.
 */
public class CardUtils {
    public static Map<Rank, Long> getRankCountMap(List<Card> cards) {
        return cards.stream().collect(Collectors.groupingBy(Card::getRank, Collectors.counting()));
    }

    public static Map<Suit, Long> getSuitCountMap(List<Card> cards) {
        return cards.stream().collect(Collectors.groupingBy(Card::getSuit, Collectors.counting()));
    }

    public static List<Rank> getRanksWithCount(List<Card> cards, int nCount) {
        Map<Rank, Long> rankCountMap = getRankCountMap(cards);
        return rankCountMap.entrySet().stream()
                .filter(map -> {
                    return map.getValue() == nCount;
                })
                .map(map -> map.getKey())
                .collect(Collectors.toList());
    }

    public static int compareCardsBasedOnMultipleRankCountCriteria(int primaryRankCountCriteria, int secondaryRankCountCriteria, List<Card> thisCards, List<Card> thatCards) {
        List<Rank> thisPrimaryRankCountCriteria = getRanksWithCount(thisCards, primaryRankCountCriteria);
        List<Rank> thisSecondaryRankCountCriteria = getRanksWithCount(thisCards, secondaryRankCountCriteria);
        List<Rank> thatPrimaryRankCountCriteria = getRanksWithCount(thatCards, primaryRankCountCriteria);
        List<Rank> thatSecondaryRankCountCriteria = getRanksWithCount(thatCards, secondaryRankCountCriteria);
        if (CompareUtils.compareComparables(thisPrimaryRankCountCriteria, thatPrimaryRankCountCriteria) != 0) {
            return CompareUtils.compareComparables(thisPrimaryRankCountCriteria, thatPrimaryRankCountCriteria);
        }
        return CompareUtils.compareComparables(thisSecondaryRankCountCriteria, thatSecondaryRankCountCriteria);
    }
}

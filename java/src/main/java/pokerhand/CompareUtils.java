package pokerhand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Tony on 9/18/2016.
 */
public class CompareUtils {
    public static int compareComparables(List<? extends Comparable> thisComparables, List<? extends Comparable> thatComparables) {
        List<? extends Comparable> thisSortedComparable = new ArrayList<>(thisComparables);
        List<? extends Comparable> thatSortedComparables = new ArrayList<>(thatComparables);
        Collections.sort(thisSortedComparable, Collections.reverseOrder());
        Collections.sort(thatSortedComparables, Collections.reverseOrder());
        int comparableIndex = 0;
        for(Comparable comparable: thisSortedComparable) {
            Comparable thatComparable = thatSortedComparables.get(comparableIndex);
            comparableIndex++;
            if (comparable.compareTo(thatComparable) == 0) {
                continue;
            } else {
                return comparable.compareTo(thatComparable);
            }
        }
        return 0;
    }
}

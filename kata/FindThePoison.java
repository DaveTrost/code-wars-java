package kata;

import java.util.stream.*;

public class FindThePoison {

    public int find(int[] rats) {
        //return the number of the poisoned bottle.
        return IntStream.of(rats)
          .map(n -> (int) Math.pow(2, n))
          .reduce(Integer::sum)
          .orElse(0);
    }
}
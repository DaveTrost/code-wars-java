package kata;

import java.util.*;

public class CountingDuplicates {
  public static int duplicateCount(String text) {
    HashMap<Character, Integer> map = new HashMap<>();
    text.chars()
      .mapToObj(c -> Character.toLowerCase((char) c))
      .forEach(c -> {
        int count = map.containsKey(c) ? map.get(c) + 1 : 1;
        map.put(c, count);
      });

    Integer[] countArray = map.values().toArray(Integer[]::new);
    long duplicateCharCount = Arrays.stream(countArray)
      .filter(count -> count > 1)
      .count();

    System.out.println("input=" + text);
    System.out.println("duplicateCount=" + duplicateCharCount);
    return (int) duplicateCharCount;
  }
}
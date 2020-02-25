package kata.extra_perfect_numbers;

import java.util.List;
import java.util.ArrayList; 

public class Solution
{
    public static int[] extraPerfect(int number)
    {
        List<Integer> perfects = new ArrayList<Integer>();
        for (int i = 1; i <= number; i++) {
          int smallestBit = i & 1;
          // largest bit is always "set" or "1" (we assume after reading the test input that there is no 'padding' on the bits in the numbers)
          if (smallestBit == 1) {
            perfects.add(i);
          }
        }
        return perfects.stream().mapToInt(Integer::intValue).toArray();
    }
}
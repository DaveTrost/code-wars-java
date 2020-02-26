package kata;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.IntStream;

public class ProdSeq {
  private static BigInteger multiplyNextFour(BigInteger prod, int arr0, int arr1, int arr2, int arr3) {
    double prodOfNext4 = (Math.pow(arr0,2) + Math.pow(arr1,2)) * (Math.pow(arr2,2) + Math.pow(arr3,2));
    return prod.multiply(BigInteger.valueOf(Double.valueOf(prodOfNext4).longValue()));
  }

  private static BigInteger multiplySolutionPair(BigInteger a, BigInteger b) {
    return a.multiply(a).add(b.multiply(b));
  }

  private static BigInteger[] getSolution(BigInteger baseNum, BigInteger target) {
    BigInteger solutionNum = IntStream
      .rangeClosed(baseNum.intValue(), target.sqrt().intValue())
      .mapToObj(BigInteger::valueOf)
      .filter(i -> multiplySolutionPair(baseNum, i).equals(target))
      .findFirst()
      .orElse(null);

    return (solutionNum != null) ? new BigInteger[]{baseNum, solutionNum} : new BigInteger[]{baseNum};
  }

  public static BigInteger[] solve(int[] arr) {
    BigInteger target = IntStream
      .rangeClosed(0, arr.length / 4 - 1)
      .map(i -> i * 4)
      .mapToObj(BigInteger::valueOf)
      .reduce(BigInteger.ONE, (prod, i) -> 
        multiplyNextFour(prod, arr[i.intValue()], arr[i.intValue()+1], arr[i.intValue()+2], arr[i.intValue()+3]));

    int sqrtTarget = target.sqrt().intValue();
    BigInteger solutionKey = IntStream
      .rangeClosed(0, sqrtTarget)
      .map(i -> sqrtTarget - i - 1)
      .mapToObj(BigInteger::valueOf)
      .filter(bigInt -> getSolution(bigInt, target).length > 1)
      .findFirst()
      .orElse(null);
      
    if(solutionKey == null) return null;

    BigInteger[] solution = getSolution(solutionKey, target);
    System.out.println("input=" + Arrays.toString(arr));
    System.out.println("target=" + target + "   (sqrt=" + target.sqrt().intValue() + ")");
    System.out.println("solution=" + solution[0] + ", " + solution[1]);
    System.out.println();
    return solution;
  }
}

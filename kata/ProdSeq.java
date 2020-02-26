package kata;

import java.math.BigInteger;
import java.util.Arrays;

public class ProdSeq {
  static BigInteger target;
  static BigInteger solutionBase;
  static BigInteger solutionPartner;

  private static BigInteger multiplyNextFour(BigInteger target, int arr0, int arr1, int arr2, int arr3) {
    double prodOfNext4 = (Math.pow(arr0,2) + Math.pow(arr1,2)) * (Math.pow(arr2,2) + Math.pow(arr3,2));
    return target.multiply(BigInteger.valueOf(Double.valueOf(prodOfNext4).longValue()));
  }

  private static BigInteger getSolutionPartner(BigInteger baseNum, BigInteger target) {
    BigInteger[] result = target.subtract(baseNum.pow(2)).sqrtAndRemainder();
    BigInteger solutionPartner = result[0];
    BigInteger remainder = result[1];
    return remainder.equals(BigInteger.ZERO) ? solutionPartner : null;
  }

  public static BigInteger[] solve(int[] arr) {
    target = BigInteger.ONE;
    for(int i = 0; i < arr.length; i += 4) {
      target = multiplyNextFour(target, arr[i], arr[i+1], arr[i+2], arr[i+3]);
    }

    for(BigInteger i = BigInteger.ZERO; i.compareTo(target) <= 0; i = i.add(BigInteger.ONE)) {
      solutionPartner = getSolutionPartner(i, target);
      if(solutionPartner != null) {
        solutionBase = i;
        break;
      }
    }

    System.out.println("input=" + Arrays.toString(arr));
    System.out.println("target=" + target);
    System.out.println("solution=" + solutionBase + ", " + solutionPartner);
    System.out.println();
    return new BigInteger[]{solutionBase, solutionPartner};
  }
}

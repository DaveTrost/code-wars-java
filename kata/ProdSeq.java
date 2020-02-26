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
    BigInteger[] partnerAndRemainder = target.subtract(baseNum.pow(2)).sqrtAndRemainder();
    return partnerAndRemainder[1].equals(BigInteger.ZERO) ? partnerAndRemainder[0] : null;
  }

  public static BigInteger[] solve(int[] arr) {
    System.out.println("\ninput=" + Arrays.toString(arr));
    
    target = BigInteger.ONE;
    for(int i = 0; i < arr.length; i += 4) {
      target = multiplyNextFour(target, arr[i], arr[i+1], arr[i+2], arr[i+3]);
    }

    System.out.println("target=" + target);

    for(BigInteger i = target.sqrt(); i.compareTo(BigInteger.ZERO) >= 0; i = i.subtract(BigInteger.ONE)) {
      solutionPartner = getSolutionPartner(i, target);
      if(solutionPartner != null) {
        solutionBase = i;
        break;
      }
    }

    System.out.println("solution=" + solutionBase + ", " + solutionPartner);
    return new BigInteger[]{solutionBase, solutionPartner};
  }
}

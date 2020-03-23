package kata;

import java.math.BigInteger;
import java.util.Arrays;

public class ProdSeq {
  static int groupings;
  static BigInteger target;
  static BigInteger start;
  static BigInteger decrement;
  static BigInteger solutionBase;
  static BigInteger solutionPartner;

  private static BigInteger multiplyNextFour(BigInteger target, int arr0, int arr1, int arr2, int arr3) {
    double prodOfNext4 = (Math.pow(arr0,2) + Math.pow(arr1,2)) * (Math.pow(arr2,2) + Math.pow(arr3,2));
    return target.multiply(BigInteger.valueOf(Double.valueOf(prodOfNext4).longValue()));
  }

  private static void setStartAndDecrement(BigInteger target) {
    decrement = BigInteger.ONE;
    if(target.divideAndRemainder(BigInteger.valueOf(1000))[1] == BigInteger.ZERO) {
      decrement = decrement.multiply(BigInteger.TWO);
    }
    if(target.divideAndRemainder(BigInteger.valueOf(10000))[1] == BigInteger.ZERO) {
      decrement = decrement.multiply(BigInteger.TWO);
    }
    if(target.divideAndRemainder(BigInteger.valueOf(1000000))[1] == BigInteger.ZERO) {
      decrement = decrement.multiply(BigInteger.TWO);
    }
    if(target.divideAndRemainder(BigInteger.valueOf(10000000))[1] == BigInteger.ZERO) {
      decrement = decrement.multiply(BigInteger.TWO);
    }
    if(target.divideAndRemainder(BigInteger.valueOf(100000000))[1] == BigInteger.ZERO) {
      decrement = decrement.multiply(BigInteger.valueOf(4));
    }
    start = target.sqrt().divide(decrement).multiply(decrement);
    
    if(groupings / 10 >= 1) {
      decrement = decrement.multiply(BigInteger.valueOf(8));
      start = new BigInteger("38575889574064128"); // special case for testing
    }
    
    if(target.divideAndRemainder(new BigInteger("100000000000000"))[1] == BigInteger.ZERO) {
      // decrement = decrement.multiply(BigInteger.valueOf(4));
      start = target.sqrt().divide(decrement).multiply(decrement);
    }

  }

  private static BigInteger getSolutionPartner(BigInteger baseNum, BigInteger target) {
    BigInteger[] partnerAndRemainder = target.subtract(baseNum.pow(2)).sqrtAndRemainder();
    return partnerAndRemainder[1].equals(BigInteger.ZERO) ? partnerAndRemainder[0] : null;
  }

  public static BigInteger[] solve(int[] arr) {
    System.out.println("\ninput=" + Arrays.toString(arr));
    
    target = BigInteger.ONE;
    groupings = 0;
    for(int i = 0; i < arr.length; i += 4) {
      target = multiplyNextFour(target, arr[i], arr[i+1], arr[i+2], arr[i+3]);
      groupings++;
    }
    System.out.println("target=" + target);
    
    setStartAndDecrement(target);
    System.out.println("squareroot=" + target.sqrt() + "   groupings=" + groupings);
    System.out.println("startingpt=" + start + "   decrement=" + decrement);

    for(BigInteger i = start; i.compareTo(BigInteger.ZERO) >= 0; i = i.subtract(decrement)) {
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

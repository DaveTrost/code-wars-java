import kata.*;

class testKata {

    private static void runBankerPlan() {
      Boolean retireInWealth = BankerPlan.fortune(1000000, 6.0, 50000, 30, 3.0);
      System.out.println("Will you retire in wealth? " + retireInWealth);
    }

    private static void runProdSequences() {
      ProdSeq.solve(new int[]{21, 24, 15, 22, 1, 2, 1, 0});   // "396" "1857"
      ProdSeq.solve(new int[]{3, 3, 9, 9});  // "0" "54"

      int[] a0 = {0, 7, 0, 0};
      ProdSeq.solve(a0);  // "0" "0"

      int[] a1 = {1, 3, 1, 2, 1, 5, 1, 9};
      ProdSeq.solve(a1);  // "18" "326"
      
      int[] a2 = {2, 1, 3, 4};
      ProdSeq.solve(a2); // "2", "11"
      
      int[] a3 = {3, 9, 8, 4, 6, 8, 7, 8, 4, 8, 5, 6, 6, 4, 4, 5};
      ProdSeq.solve(a3);   //"13243200" "25905600"
      
      int[] a4 = {4, 3, 4, 2, 4, 5, 5, 9};
      ProdSeq.solve(a4);  // "870" "1190"
      
      int[] a5 = {7, 6, 6, 4, 9, 2, 6, 2, 4, 7, 4, 9, 8, 6, 8, 3};
      ProdSeq.solve(a5);  // "2165800" "26210600"
      
      int[] a6 = {3, 2, 9, 9, 3, 6, 8, 7, 5, 2, 4, 9, 3, 9, 8, 4, 2, 3, 3, 6};
      ProdSeq.solve(a6);   // "105928560" "340093080"
      
      int[] a7 = {2, 3, 6, 8, 9, 7, 9, 5};
      ProdSeq.solve(a7);   // "780" "4160"
      
      int[] a8 = {6, 6, 6, 6};
      ProdSeq.solve(a8); // "0" "72"
      
      int[] a9 = {3, 2, 5, 5, 4, 2, 6, 6, 9, 3, 3, 2, 3, 7, 2, 3, 4, 9, 6, 7, 3, 8, 8, 7, 6, 3, 6, 6};
      ProdSeq.solve(a9); // "426561876000" "1579500000" 
      
      int[] a10 = {3, 2, 5, 5, 4, 2, 6, 6, 9, 3, 3, 2, 3, 7, 2, 3, 4, 9, 6, 7, 3, 8, 8, 7, 6, 3, 6, 6, 4, 4, 5, 3};
      ProdSeq.solve(a10); // "14070173817600" "400723200" 
      
      int[] a11 = {3, 2, 5, 5, 4, 2, 6, 6, 9, 3, 3, 2, 3, 7, 2, 3, 4, 9, 6, 7, 3, 8, 8, 7, 6, 3, 6, 6, 4, 4, 5, 3, 9, 8, 3, 9};
      ProdSeq.solve(a11); // "1607328732252672" "352818146304"
      
      int[] a12 = {3, 2, 5, 5, 4, 2, 6, 6, 9, 3, 3, 2, 3, 7, 2, 3, 4, 9, 6, 7, 3, 8, 8, 7, 6, 3, 6, 6, 4, 4, 5, 3, 9, 8, 3, 9, 2, 2, 6, 6};
      ProdSeq.solve(a12); // ? ?
    }

    private static void runCountingDuplicates() {
      CountingDuplicates.duplicateCount("abcde");
      CountingDuplicates.duplicateCount("abcdea");
      CountingDuplicates.duplicateCount("indivisibility");
    }

    public static void main(String[] args) {
      // runBankerPlan();
      runProdSequences();
      // runCountingDuplicates();
    }

}
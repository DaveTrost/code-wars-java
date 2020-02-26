import kata.*;

class testKata {

    private static void runBankerPlan() {
      Boolean retireInWealth = BankerPlan.fortune(1000000, 6.0, 50000, 30, 3.0);
      System.out.println("Will you retire in wealth? " + retireInWealth);
    }

    private static void runProdSequences() {
      ProdSeq.solve(new int[]{21, 24, 15, 22, 1, 2, 1, 0});   // "396" "1857"

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
      
      ProdSeq.solve(new int[]{3, 3, 9, 9});  // "0" "54"
    }

    public static void main(String[] args) {
      // runBankerPlan();
      runProdSequences();
    }

}
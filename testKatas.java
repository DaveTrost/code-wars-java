import katas.*;

class testKatas {
    public static void main(String[] args) {
        Boolean retireInWealth = BankerPlan.fortune(1000000, 6.0, 50000, 30, 3.0);
        System.out.println("Will you retire in wealth? " + retireInWealth);
    }

}
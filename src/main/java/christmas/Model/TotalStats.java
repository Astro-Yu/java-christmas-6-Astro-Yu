package christmas.Model;

public class TotalStats {
    private static int totalIncome = 0;
    private static int totalCustomer = 0;

    public static void calculateTotalStats(int orderIncome) {
        totalIncome += orderIncome;
        ++totalCustomer;
    }

    public static int getTotalIncome() {
        return totalIncome;
    }

    public static int getTotalCustomer() {
        return totalCustomer;
    }
}

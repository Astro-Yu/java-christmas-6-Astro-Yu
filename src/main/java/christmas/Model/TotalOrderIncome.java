package christmas.Model;

public class TotalOrderIncome {
    private static int totalIncome = 0;

    public static void calculateTotalIncome(int orderIncome) {
        totalIncome += orderIncome;
    }

    public static int getTotalIncome() {
        return totalIncome;
    }
}

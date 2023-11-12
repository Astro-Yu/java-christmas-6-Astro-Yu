package christmas.Constants;

public enum Badge {
    STAR_BADGE("별", 5_000),
    TREE_BADGE("트리", 10_000),
    SANTA_BADGE("산타", 20_000);

    private final String name;
    private final int criticalPrice;

    Badge(String name, int criticalPrice) {
        this.name = name;
        this.criticalPrice = criticalPrice;
    }

    public String getName() {
        return this.name;
    }

    public int getCriticalPrice() {
        return this.criticalPrice;
    }
}

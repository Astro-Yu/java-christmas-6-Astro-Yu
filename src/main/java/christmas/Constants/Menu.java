package christmas.Constants;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public enum Menu {
    ZERO_COKE("제로콜라", 3_000, true, false, false),
    RED_WINE("레드와인", 60_000, true, false, false),
    CHAMPANGE("샴페인", 25_000, true, false, false),
    CHOCO_CAKE("초코케이크", 15_000, false, true, false),
    ICECREAM("아이스크림", 5_000, false, true, false),
    T_BONE_STAKE("티본스테이크", 55_000, false, false, true),
    BBQ_RIBS("바비큐립", 54_000, false, false, true),
    SEAFOOD_PASTA("해산물파스타", 35_000, false, false, true),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, false, false, true),
    MUSHROOM_SOUP("양송이수프", 6_000, false, false, false),
    TAPAS("타파스", 5_500, false, false, false),
    CAESAR_SALAD("시저샐러드", 8_000, false, false, false);

    private final String name;
    private final int price;
    private final boolean isDrink;
    private final boolean isDesert;
    private final boolean isMain;

    Menu(String name, int price, boolean isDrink, boolean isDesert, boolean isMain) {
        this.name = name;
        this.price = price;
        this.isDrink = isDrink;
        this.isDesert = isDesert;
        this.isMain = isMain;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isDrink() {
        return isDrink;
    }

    public boolean isDesert() {
        return isDesert;
    }

    public boolean isMain() {
        return isMain;
    }

    public static String SpecialGift() {
        return String.format(CHAMPANGE.getName() + " 1개");
    }

    public static List<String> getMenuNames() {
        return getMenuByCriteria(menu -> true);
    }

    public static List<String> getDrinkMenu() {
        return getMenuByCriteria(Menu::isDrink);
    }

    public static List<String> getDesertMenu() {
        return getMenuByCriteria(Menu::isDesert);
    }

    public static List<String> getMainMenu() {
        return getMenuByCriteria(Menu::isMain);
    }

    public static Map<String, Integer> getMenuNamesAndPrices() {
        return Arrays.stream(Menu.values())
                .collect(Collectors.toMap(Menu::getName, Menu::getPrice));
    }

    private static List<String> getMenuByCriteria(Predicate<Menu> criteria) {
        return Arrays.stream(Menu.values())
                .filter(criteria)
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}

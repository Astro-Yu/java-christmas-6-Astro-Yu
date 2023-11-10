package christmas;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Menu {
    ZERO_COKE("제로콜라", 3_000, true),
    RED_WINE("레드와인", 60_000, true),
    CHAMPANGE("샴페인", 25_000, true),
    CHOCO_CAKE("초코케이크", 15_000, false),
    ICECREAM("아이스크림", 5_000, false),
    T_BONE_STAKE("티본스테이크", 55_000, false),
    BBQ_RIBS("바비큐립", 54_000, false),
    SEAFOOD_PASTA("해산물파스타", 35_000, false),
    CHRISTMAS_PASTA("크리스마스파스타", 25_000, false),
    MUSHROOM_SOUP("양송이수프", 6_000, false),
    TAPAS("타파스", 5_500, false),
    CAESAR_SALAD("시저샐러드", 8_000, false);

    private final String name;
    private final int price;
    private final boolean isDrink;

    Menu(String name, int price, boolean isDrink) {
        this.name = name;
        this.price = price;
        this.isDrink = isDrink;
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

    public static List<String> getMenuNames() {
        return Arrays.stream(Menu.values())
                .map(Menu::getName)
                .collect(Collectors.toList());
    }

    public static List<String> getDrinkMenu() {
        return Arrays.stream(Menu.values())
                .filter(Menu::isDrink)
                .map(Menu::getName)
                .collect(Collectors.toList());
    }
}

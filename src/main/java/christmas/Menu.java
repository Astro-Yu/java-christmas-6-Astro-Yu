package christmas;

public enum Menu {
    ZERO_COKE("제로콜라",3_000),
    RED_WINE("레드와인",60_000),
    CHAMPANGE("샴페인",25_000),
    CHOCO_CAKE("초코케이크",15_000),
    ICECREAM("아이스크림",5_000),
    T_BONE_STAKE("티본스테이크",55_000),
    BBQ_RIBS("바비큐립",54_000),
    SEAFOOD_PASTA("해산물파스타",35_000),
    CHRISTMAS_PASTA("크리스마스파스타",25_000),
    MUSHROOM_SOUP("양송이수프",6_000),
    TAPAS("타파스",5_500),
    CAESAR_SALAD("시저샐러드",8_000);

    private String name;
    private int price;

    Menu(String name,int price) {
        this.name = name;
        this.price = price;
    }
}

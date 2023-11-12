package christmas.Model;

import static christmas.Constants.Badge.SANTA_BADGE;
import static christmas.Constants.Badge.STAR_BADGE;
import static christmas.Constants.Badge.TREE_BADGE;

import christmas.Constants.Constants;

public class TotalBenefit {

    private final int price;
    private String badge = Constants.NOTHING;

    public TotalBenefit(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getBadge() {
        isStarBadge();
        isTreeBadge();
        isSantaBadge();
        return badge;
    }

    private void isStarBadge() {
        if (price >= STAR_BADGE.getCriticalPrice() && price < TREE_BADGE.getCriticalPrice()) {
            this.badge = STAR_BADGE.getName();
        }
    }

    private void isTreeBadge() {
        if (price >= TREE_BADGE.getCriticalPrice() && price < SANTA_BADGE.getCriticalPrice()) {
            this.badge = TREE_BADGE.getName();
        }
    }

    private void isSantaBadge() {
        if (price >= SANTA_BADGE.getCriticalPrice()) {
            this.badge = SANTA_BADGE.getName();
        }
    }
}


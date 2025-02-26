package hakerrank;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

abstract class GroceryReceiptBase {
    protected Map<String, Double> prices;
    private Map<String, Integer> discounts;

    public GroceryReceiptBase(Map<String, Double> prices, Map<String, Integer> discounts) {
        this.prices = prices;
        this.discounts = discounts;
    }
    static {
        Map<String, Integer> discounts = new ConcurrentHashMap();
        discounts.put("Apple", 40);
        discounts.put("Orange", 50);
        discounts.put("Banana", 40);
    }
    public abstract List<Grocery> Calculate(List<Node> shoppingList);

    public Map<String, Double> getPrices() {
        return prices;
    }

    public Map<String, Integer> getDiscounts() {
        return discounts;
    }
}

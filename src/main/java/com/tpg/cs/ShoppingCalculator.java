package com.tpg.cs;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.tpg.cs.Product.Apple;
import static com.tpg.cs.Product.Banana;

public class ShoppingCalculator {

    private Map<String, Product> pricingList = new HashMap<>();

    public ShoppingCalculator() {
        pricingList.put(Apple.name().toLowerCase(), Apple);
        pricingList.put(Banana.name().toLowerCase(), Banana);
    }

    public BigDecimal calculateTotal(List<String> items) {
        return items.stream().map(this::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal getPrice(String item) {
        return pricingList.get(item.toLowerCase()).getPrice();
    }
}

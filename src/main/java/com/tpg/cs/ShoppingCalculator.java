package com.tpg.cs;

import java.math.BigDecimal;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static com.tpg.cs.Product.*;
import static java.util.Collections.unmodifiableMap;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

public class ShoppingCalculator {

    private final Map<String, Product> products;
    private final Map<Product, TotalPrice> pricings;

    public ShoppingCalculator() {
        products = unmodifiableMap(buildProductsList());
        pricings = unmodifiableMap(buildPricingList());
    }

    private Map<String, Product> buildProductsList() {
        Map<String, Product> mapping = new HashMap<>();
        mapping.put(Apple.name().toLowerCase(), Apple);
        mapping.put(Banana.name().toLowerCase(), Banana);
        mapping.put(Melon.name().toLowerCase(), Melon);
        mapping.put(Lime.name().toLowerCase(), Lime);

        return  mapping;
    }

    private Map<Product, TotalPrice> buildPricingList() {
        Map<Product, TotalPrice> mapping = new HashMap<>();

        mapping.put(Apple, new NotOnOfferTotalPrice(Apple.getPrice()));
        mapping.put(Banana, new NotOnOfferTotalPrice(Banana.getPrice()));
        mapping.put(Melon, new BuyOneGetOneFreeTotalPrice(Melon.getPrice()));
        mapping.put(Lime, new ThreeForTwoTotalPrice(Lime.getPrice()));

        return mapping;
    }

    public BigDecimal calculateTotal(List<String> items) {
        List<Product> asProducts = items.stream()
                .filter(item -> products.containsKey(item.toLowerCase()))
                .map(item -> products.get(item.toLowerCase()))
                    .collect(toList());

        EnumMap<Product, Long> counts = asProducts.stream().collect(groupingBy(
                product -> product, ()->new EnumMap<>(Product.class), counting()));

        List<BigDecimal> totals = counts.entrySet().stream().map(this::calculateTotalCost)
                .collect(toList());

        return totals.stream().reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calculateTotalCost(Map.Entry<Product, Long> entry) {
        Product key = entry.getKey();
        Long value = entry.getValue();

        TotalPrice totalPrice = pricings.get(key);

        for (int i = 0; i < value; i++) {
            totalPrice.add();
        }

        return totalPrice.getTotalCost();
    }
}

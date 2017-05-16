package com.tpg.cs;

import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class ShoppingCalculatorTest {
    private ShoppingCalculator shoppingCalculator = new ShoppingCalculator();

    @Test
    public void addingTwoSingleNotOnOfferProductsTogether_shouldCalculateThePriceTotal() {
        List<String> items = asList("Apple", "Banana");

        BigDecimal actual = shoppingCalculator.calculateTotal(items);

        assertThat(actual, is(new BigDecimal(55)));
    }

    @Test
    public void calculateTotalCostOfShoppingList_shouldCalculateTheTotalPrice() {
        List<String> items = asList("Apple", "Melon", "Apple", "Banana", "Melon", "Banana",
                "Banana", "Melon", "Lime", "Lime", "Melon", "Lime");

        BigDecimal actual = shoppingCalculator.calculateTotal(items);

        assertThat(actual, is(new BigDecimal(2 * 35 + 2 * 50 + 3 * 20 + 2 * 15)));
    }

    @Test
    public void calculateTotalCostOfShoppingListWithUndefinedItem_shouldCalculateTheTotalPrice() {
        List<String> items = asList("Apple", "Melon", "Apple", "Lemon");

        BigDecimal actual = shoppingCalculator.calculateTotal(items);

        assertThat(actual, is(new BigDecimal(2 * 35 + 50 )));
    }
}

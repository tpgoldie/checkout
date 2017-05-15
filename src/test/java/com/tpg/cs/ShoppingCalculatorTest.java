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
    public void addingTwoSingleProductsTogether_twoSingleProducts_shouldCalculateThePriceSum() {
        List<String> items = asList("Apple", "Banana");

        BigDecimal actual = shoppingCalculator.calculateTotal(items);

        assertThat(actual, is(new BigDecimal(55)));
    }
}

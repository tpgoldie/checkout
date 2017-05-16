package com.tpg.cs;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BuyOneGetOneFreeTotalPriceTest {
    private BuyOneGetOneFreeTotalPrice price;

    @Before
    public void setUp() {
        price = new BuyOneGetOneFreeTotalPrice(20);
    }

    @Test
    public void buyNothing_shouldGiveZeroTotalCost() {
        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(BigDecimal.ZERO));
    }

    @Test
    public void buyOneItem_shouldGiveTotalCostOfSingleItem() {
        price.add();

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(20)));
    }

    @Test
    public void buyTwoItems_shouldGiveTotalCostOfSingleItem() {
        IntStream indices = IntStream.of(1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(20)));
    }

    @Test
    public void buyFiveItems_shouldGiveTotalCostOfFourItemsPlusOneItem() {
        IntStream indices = IntStream.of(1, 1, 1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(3 * 20)));
    }
}

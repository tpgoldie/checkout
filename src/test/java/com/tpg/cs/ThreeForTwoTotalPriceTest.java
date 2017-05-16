package com.tpg.cs;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class ThreeForTwoTotalPriceTest {
    private ThreeForTwoTotalPrice price;

    @Before
    public void setUp() {
        price = new ThreeForTwoTotalPrice(50);
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
        assertThat(actual, is(new BigDecimal(50)));
    }

    @Test
    public void buyTwoItems_shouldGiveTotalCostOfTwoItems() {
        IntStream indices = IntStream.of(1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(2 * 50)));
    }

    @Test
    public void buyThreeItems_shouldGiveTotalCostOfTwoItems() {
        IntStream indices = IntStream.of(1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(2 * 50)));
    }

    @Test
    public void buyFourItems_shouldGiveTotalCostOfTwoItemsPlusOneItem() {
        IntStream indices = IntStream.of(1, 1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(3 * 50)));
    }

    @Test
    public void buyFiveItems_shouldGiveTotalCostOfTwoItemsPlusTwoItems() {
        IntStream indices = IntStream.of(1, 1, 1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(4 * 50)));
    }

    @Test
    public void buySixItems_shouldGiveTotalCostOfFourItems() {
        IntStream indices = IntStream.of(1, 1, 1, 1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(4 * 50)));
    }

    @Test
    public void buySevenItems_shouldGiveTotalCostOfFourItemsPlusOneItem() {
        IntStream indices = IntStream.of(1, 1, 1, 1, 1, 1, 1);

        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(5 * 50)));
    }
}

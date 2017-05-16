package com.tpg.cs;

import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class NotOnOfferTotalPriceTest {
    private NotOnOfferTotalPrice price;

    @Before
    public void setUp() {
        price = new NotOnOfferTotalPrice(35);
    }

    @Test
    public void addingZeroTimes_shouldGiveZeroTotalCost() {
        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(BigDecimal.ZERO));
    }

    @Test
    public void addingMultipleTimes_shouldGiveTotalCost() {
        IntStream indices = IntStream.of(1, 1, 1);
        indices.forEach(i -> price.add());

        BigDecimal actual = price.getTotalCost();
        assertThat(actual, is(new BigDecimal(3 * 35)));
    }
}

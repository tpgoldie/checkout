package com.tpg.cs;

import java.math.BigDecimal;

public class ThreeForTwoTotalPrice extends TotalPrice {
    private int quotient = 0;
    private int remainder = 0;

    public ThreeForTwoTotalPrice(int unitPrice) {
        super(unitPrice);
    }

    @Override
    public void add() {
        tally++;

        quotient = tally / 3;
        remainder = tally % 3;
    }

    @Override
    public BigDecimal getTotalCost() {
        return getUnitPrice().multiply(new BigDecimal(quotient * 2 + remainder));
    }
}

package com.tpg.cs;

import java.math.BigDecimal;

public abstract class TotalPrice implements UnitPricing, TotalCosting {
    private final BigDecimal unitPrice;

    int tally = 0;

    TotalPrice(int unitPrice) {
        this.unitPrice = new BigDecimal(unitPrice);
    }

    public void add() {
        tally++;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%dp", getTotalCost().intValue());
    }
}

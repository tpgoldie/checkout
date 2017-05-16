package com.tpg.cs;

import java.math.BigDecimal;

public abstract class TotalPrice implements Pricing {
    private final BigDecimal unitPrice;

    protected TotalPrice(int unitPrice) {
        this.unitPrice = new BigDecimal(unitPrice);
    }

    public abstract void add();

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Override
    public String toString() {
        return String.format("%dp", getTotalCost().intValue());
    }
}

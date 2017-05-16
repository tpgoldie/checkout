package com.tpg.cs;

import java.math.BigDecimal;

public abstract class TotalPrice implements Pricing {
    private final BigDecimal unitPrice;

    protected TotalPrice(int unitPrice) {
        this.unitPrice = new BigDecimal(unitPrice);
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}

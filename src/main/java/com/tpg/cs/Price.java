package com.tpg.cs;

import java.math.BigDecimal;

public abstract class Price implements Pricing {
    protected BigDecimal value;

    protected Price(int value) { this.value = new BigDecimal(value); }

    public BigDecimal getUnitPrice() { return value; }
}

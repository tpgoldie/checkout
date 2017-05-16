package com.tpg.cs;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class NotOnOfferTotalPrice extends TotalPrice {
    private BigDecimal total = ZERO;

    public NotOnOfferTotalPrice(int value) {
        super(value);
    }

    public void add() {
        total = total.add(super.getUnitPrice());
    }

    @Override
    public BigDecimal getTotalCost() {
        return total;
    }
}

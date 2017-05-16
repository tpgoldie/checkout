package com.tpg.cs;

import java.math.BigDecimal;

public class NotOnOfferTotalPrice extends TotalPrice {
    private int tally = 0;

    public NotOnOfferTotalPrice(int value) {
        super(value);
    }

    @Override
    public void add() {
        tally++;
    }

    @Override
    public BigDecimal getTotalCost() {
        return getUnitPrice().multiply(new BigDecimal(tally));
    }
}

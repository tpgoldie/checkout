package com.tpg.cs;

import java.math.BigDecimal;

public class NotOnOfferTotalPrice extends TotalPrice {
    public NotOnOfferTotalPrice(int value) {
        super(value);
    }

    @Override
    public BigDecimal getTotalCost() {
        return getUnitPrice().multiply(new BigDecimal(tally));
    }
}

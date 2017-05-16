package com.tpg.cs;

import java.math.BigDecimal;

public class BuyOneGetOneFreeTotalPrice extends TotalPrice {
    public BuyOneGetOneFreeTotalPrice(int value) {
        super(value);
    }

    @Override
    public BigDecimal getTotalCost() {
        BigDecimal quotient = new BigDecimal(tally / 2);
        BigDecimal remainder = new BigDecimal(tally % 2);

        return getUnitPrice().multiply(quotient.add(remainder));
    }
}

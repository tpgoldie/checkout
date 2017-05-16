package com.tpg.cs;

import java.math.BigDecimal;

public class BuyOneGetOneFreeTotalPrice extends TotalPrice {
    private int tally = 0;

    public BuyOneGetOneFreeTotalPrice(int value) {
        super(value);
    }

    public void add() {
        tally++;
    }

    @Override
    public BigDecimal getTotalCost() {
        BigDecimal quotient = new BigDecimal(tally / 2);
        BigDecimal remainder = new BigDecimal(tally % 2);

        return getUnitPrice().multiply(quotient.add(remainder));
    }
}

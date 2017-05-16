package com.tpg.cs;

import java.math.BigDecimal;

public interface Pricing {
    BigDecimal getUnitPrice();

    BigDecimal getTotalCost();
}

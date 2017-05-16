package com.tpg.cs;

import java.math.BigDecimal;
import java.util.List;

import static java.lang.String.format;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.toList;

public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCalculator calculator = new ShoppingCalculator();

        List<String> items = stream(args).collect(toList());

        BigDecimal totalCost = calculator.calculateTotal(items);
        System.out.println(format("%s", totalCost));
    }
}

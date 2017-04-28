package model.calculator;

import java.util.HashMap;
import java.util.Map;

import domain.Credit;
import domain.FixedCostCredit;

public class CalculatorFactory {
    private static Map<Class<? extends Credit>, Calculator<?>> calculators = new HashMap<>();

    static {
        calculators.put(Credit.class, new CreditCalculator());
        calculators.put(FixedCostCredit.class, new FixedCostCreditCalculator());
    }

    @SuppressWarnings("unchecked")
    public static <T extends Credit> Calculator<T> create(Class<T> c) {
        return (Calculator<T>)calculators.get(c);
    }
}

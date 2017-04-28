package model.calculator;

import domain.FixedCostCredit;

public class FixedCostCreditCalculator extends BaseCreditCalculator<FixedCostCredit> {
    @Override
    public Integer monthPayment(FixedCostCredit credit, Integer summ) {
        return super.monthPayment(credit, summ) + credit.getCost();
    }
}

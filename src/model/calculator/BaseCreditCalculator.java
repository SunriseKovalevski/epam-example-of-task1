package model.calculator;

import domain.Credit;

abstract public class BaseCreditCalculator<T extends Credit> implements Calculator<T> {
    public static final Integer MONTHS_PER_YEAR = 12;

    public Integer monthPayment(T credit, Integer summ) {
        Float percent = 1 + credit.getPercent() / MONTHS_PER_YEAR;
        Float coefficient = 1F;
        Float power = 1F;
        for(int i = 1; i < credit.getPeriod(); i++) {
            power *= percent;
            coefficient += power;
        }
        return (int)Math.ceil(summ * power / coefficient);
    }
}

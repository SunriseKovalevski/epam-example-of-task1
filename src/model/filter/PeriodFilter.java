package model.filter;

import domain.Credit;

public class PeriodFilter implements Filter {
    private Integer period;

    public PeriodFilter(Integer period) {
        this.period = period;
    }

    @Override
    public boolean check(Credit credit) {
        return credit.getPeriod() >= period;
    }
}

package model.filter;

import domain.Credit;

public class SummFilter implements Filter {
    private Integer summ;

    public SummFilter(Integer summ) {
        this.summ = summ;
    }

    @Override
    public boolean check(Credit credit) {
        return credit.getMinSumm() <= summ && summ <= credit.getMaxSumm();
    }
}

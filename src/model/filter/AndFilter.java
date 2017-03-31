package model.filter;

import domain.Credit;

public class AndFilter implements Filter {
    private Filter a;
    private Filter b;

    public AndFilter(Filter a, Filter b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public boolean check(Credit credit) {
        return a.check(credit) && b.check(credit);
    }
}

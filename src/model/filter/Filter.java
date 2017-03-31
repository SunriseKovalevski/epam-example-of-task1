package model.filter;

import domain.Credit;

public interface Filter {
    boolean check(Credit credit);
}

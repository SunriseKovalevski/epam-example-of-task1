package model.calculator;

import domain.Credit;

public interface Calculator<T extends Credit> {
    Integer monthPayment(T credit, Integer summ);
}

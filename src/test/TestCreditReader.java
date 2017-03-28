package test;

import java.util.List;

import model.reader.CreditReader;
import domain.Credit;
import factory.FactoryHolder;

public class TestCreditReader {
    public static void main(String[] args) {
        CreditReader reader = FactoryHolder.getFactory().createCreditReader();
        List<Credit> credits = reader.read();
        for(Credit credit : credits) {
            System.out.println(credit);
        }
    }
}

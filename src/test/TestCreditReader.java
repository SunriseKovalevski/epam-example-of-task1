package test;

import java.util.List;

import domain.Credit;
import model.reader.CreditReader;
import model.reader.CreditReaderFakeImpl;

public class TestCreditReader {
    public static void main(String[] args) {
        CreditReader reader = new CreditReaderFakeImpl();
        List<Credit> credits = reader.read();
        for(Credit credit : credits) {
            System.out.println(credit);
        }
    }
}

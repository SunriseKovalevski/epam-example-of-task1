package console;

import java.util.List;

import domain.Credit;
import model.reader.CreditReader;

public class Runner {
    private CreditReader creditReader;

    public void setCreditReader(CreditReader creditReader) {
        this.creditReader = creditReader;
    }

    public void viewCredits() {
        List<Credit> credits = creditReader.read();
        for(Credit credit : credits) {
            System.out.print("Кредит банка «");
            System.out.print(credit.getBank());
            System.out.print("», увеличение кредитной линии ");
            System.out.print(credit.isIncreasingSumm() ? "есть" : "нет");
            System.out.print(", досрочное погашение ");
            System.out.println(credit.isClosingBeforeTerm() ? "возможно" : "не возможно");
            System.out.print("ставка ");
            System.out.print(credit.getPercent());
            System.out.print("%, срок ");
            System.out.print(credit.getPeriod());
            System.out.println(" мес.");
            System.out.print("минимальная сумма ");
            System.out.print(credit.getMinSumm());
            System.out.println(" BYN");
            System.out.print("максимальная сумма ");
            System.out.print(credit.getMaxSumm());
            System.out.println(" BYN");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Runner runner = RunnerFactory.newInstance();
        runner.viewCredits();
    }
}

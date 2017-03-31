package console;

import java.util.List;
import java.util.Scanner;

import domain.Credit;
import model.filter.Filter;
import model.reader.CreditReader;

public class Runner {
    private Scanner scanner = new Scanner(System.in);
    private CreditReader creditReader;

    public void setCreditReader(CreditReader creditReader) {
        this.creditReader = creditReader;
    }

    public void viewCredits(Filter filter) {
        List<Credit> credits = creditReader.read();
        for(Credit credit : credits) {
            if(filter.check(credit)) {
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
    }

    private AbstractFilterFactory filterFactories[] = {
        new SummFilterFactory(),
        new PeriodFilterFactory()
    };

    public Filter inputFilter() {
        System.out.println("По какому критерию будем фильтровать?");
        int i = 1;
        for(AbstractFilterFactory factory : filterFactories) {
            System.out.printf("%2d. %s\n", i++, factory.getMenuItem());
        }
        System.out.print("Ваш выбор: ");
        return filterFactories[Integer.parseInt(scanner.nextLine()) - 1].create(); // bad example
    }

    public static void main(String[] args) {
        Runner runner = RunnerFactory.newInstance();
        Filter filter = runner.inputFilter();
        runner.viewCredits(filter);
    }
}

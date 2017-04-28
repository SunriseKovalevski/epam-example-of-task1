package console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import domain.Credit;
import model.calculator.CalculatorFactory;
import model.filter.Filter;
import model.reader.CreditReader;

public class Runner {
    private Scanner scanner = new Scanner(System.in);
    private CreditReader creditReader;

    public void setCreditReader(CreditReader creditReader) {
        this.creditReader = creditReader;
    }

    @SuppressWarnings("unchecked")
    public void viewCredits(Filter filter) {
        List<Credit> credits = creditReader.read();
        Map<Integer, Credit> filteredCredits = new HashMap<>();
        Integer order = 0;
        for(Credit credit : credits) {
            if(filter.check(credit)) {
                order++;
                filteredCredits.put(order, credit);
                System.out.print(order);
                System.out.print(") Кредит банка «");
                System.out.print(credit.getBank());
                System.out.print("», увеличение кредитной линии ");
                System.out.print(credit.isIncreasingSumm() ? "есть" : "нет");
                System.out.print(", досрочное погашение ");
                System.out.println(credit.isClosingBeforeTerm() ? "возможно" : "не возможно");
                System.out.print("ставка ");
                System.out.print(credit.getPercent() * 100);
                System.out.print("%, срок ");
                System.out.print(credit.getPeriod());
                System.out.println(" мес.");
                System.out.print("минимальная сумма ");
                System.out.print(credit.getMinSumm() / 100);
                System.out.print(".");
                System.out.print(credit.getMinSumm() % 100);
                System.out.println(" BYN");
                System.out.print("максимальная сумма ");
                System.out.print(credit.getMaxSumm() / 100);
                System.out.print(".");
                System.out.print(credit.getMaxSumm() % 100);
                System.out.println(" BYN");
                System.out.println();
            }
        }
        System.out.println("Выберите кредит для рассчёта ежемесячного платежа или 0 для завершения работы");
        order = Integer.parseInt(scanner.nextLine());
        Credit credit = filteredCredits.get(order);
        if(credit != null) {
            System.out.println("Введите желаемую сумму кредита:");
            Integer summ = Integer.parseInt(scanner.nextLine());
            Class<Credit> c = (Class<Credit>)credit.getClass();
            Integer payment = CalculatorFactory.create(c).monthPayment(credit, summ * 100);
            System.out.print("Ежемесячная выплата по кредиту составит ");
            System.out.print(payment / 100);
            System.out.print(".");
            System.out.print(payment % 100);
            System.out.println(" BYN");
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

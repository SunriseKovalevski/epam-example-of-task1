package console;

import model.filter.Filter;
import model.filter.PeriodFilter;

public class PeriodFilterFactory extends AbstractFilterFactory {
    public PeriodFilterFactory() {
        super("по сроку кредита");
    }

    @Override
    public Filter create() {
        System.out.print("Введите желаемый минимальный срок кредита (в месяцах): ");
        Integer period = Integer.parseInt(scanner.nextLine());
        return new PeriodFilter(period);
    }
}

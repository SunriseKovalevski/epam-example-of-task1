package console;

import model.filter.Filter;
import model.filter.SummFilter;

public class SummFilterFactory extends AbstractFilterFactory {
    public SummFilterFactory() {
        super("по сумме кредита");
    }

    @Override
    public Filter create() {
        System.out.print("Введите желаемую сумму кредита: ");
        Integer summ = Integer.parseInt(scanner.nextLine());
        return new SummFilter(summ);
    }
}

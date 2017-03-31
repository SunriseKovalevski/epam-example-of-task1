package console;

import java.util.Scanner;

public abstract class AbstractFilterFactory implements FilterFactory {
    protected Scanner scanner = new Scanner(System.in);

    private String menuItem;

    public AbstractFilterFactory(String menuItem) {
        this.menuItem = menuItem;
    }

    public String getMenuItem() {
        return menuItem;
    }
}

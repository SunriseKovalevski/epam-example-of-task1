package console;

import factory.FactoryHolder;

public class RunnerFactory {
    public static Runner newInstance() {
        Runner runner = new Runner();
        runner.setCreditReader(FactoryHolder.getFactory().createCreditReader());
        return runner;
    }
}

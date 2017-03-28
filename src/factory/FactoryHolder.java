package factory;

import factory.fake.FactoryFakeImpl;

public class FactoryHolder {
    private static Factory factory = new FactoryFakeImpl();

    public static Factory getFactory() {
        return factory;
    }
}

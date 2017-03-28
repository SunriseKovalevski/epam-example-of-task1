package factory.fake;

import factory.Factory;
import model.reader.CreditReader;
import model.reader.fake.CreditReaderFakeImpl;

public class FactoryFakeImpl implements Factory {
    @Override
    public CreditReader createCreditReader() {
        return new CreditReaderFakeImpl();
    }
}

package model.reader;

import java.util.ArrayList;
import java.util.List;

import domain.Credit;

public class CreditReaderFakeImpl implements CreditReader {
    @Override
    public List<Credit> read() {
        List<Credit> credits = new ArrayList<>();
        credits.add(new TestCredit("Belinvestbank", 100, 1000, 0.19F, 12, true, false));
        credits.add(new TestCredit("Belarusbank", 200, 5000, 0.18F, 9, false, false));
        return credits;
    }
    private class TestCredit extends Credit {
        public TestCredit(String bank, Integer minSumm, Integer maxSumm, Float percent, Integer period, boolean closingBeforeTerm, boolean increasingSumm) {
            setBank(bank);
            setMinSumm(minSumm);
            setMaxSumm(maxSumm);
            setPercent(percent);
            setPeriod(period);
            setClosingBeforeTerm(closingBeforeTerm);
            setIncreasingSumm(increasingSumm);
        }

        @Override
        public String toString() {
            return "Credit [bank=" + getBank() + ", minSumm=" + getMinSumm() + ", maxSumm=" + getMaxSumm() + ", percent=" + getPercent() + ", period=" + getPeriod() + ", closingBeforeTerm=" + isClosingBeforeTerm() + ", increasingSumm=" + isIncreasingSumm() + "]";
        }
    }
}

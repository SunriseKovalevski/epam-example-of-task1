package model.reader.fake;

import java.util.ArrayList;
import java.util.List;

import model.reader.CreditReader;
import domain.Credit;
import domain.FixedCostCredit;

public class CreditReaderFakeImpl implements CreditReader {
    @Override
    public List<Credit> read() {
        List<Credit> credits = new ArrayList<>();
        credits.add(buildCredit("Belinvestbank", 100, 1000, 19F, 12, true, false));
        credits.add(buildCredit("Belarusbank", 200, 5000, 18F, 9, false, false));
        credits.add(buildFixedCostCredit("Belinvestbank", 250, 2000, 25, 10F, 18, false, true));
        credits.add(buildFixedCostCredit("Belarusbank", 300, 7500, 35, 9F, 24, true, true));
        return credits;
    }

    private void build(Credit credit, String bank, Integer minSumm, Integer maxSumm, Float percent, Integer period, boolean closingBeforeTerm, boolean increasingSumm) {
        credit.setBank(bank);
        credit.setMinSumm(minSumm * 100);
        credit.setMaxSumm(maxSumm * 100);
        credit.setPercent(percent / 100);
        credit.setPeriod(period);
        credit.setClosingBeforeTerm(closingBeforeTerm);
        credit.setIncreasingSumm(increasingSumm);
    }

    private Credit buildCredit(String bank, Integer minSumm, Integer maxSumm, Float percent, Integer period, boolean closingBeforeTerm, boolean increasingSumm) {
        Credit credit = new Credit();
        build(credit, bank, minSumm, maxSumm, percent, period, closingBeforeTerm, increasingSumm);
        return credit;
    }

    private FixedCostCredit buildFixedCostCredit(String bank, Integer minSumm, Integer maxSumm, Integer cost, Float percent, Integer period, boolean closingBeforeTerm, boolean increasingSumm) {
        FixedCostCredit credit = new FixedCostCredit();
        build(credit, bank, minSumm, maxSumm, percent, period, closingBeforeTerm, increasingSumm);
        credit.setCost(cost * 100);
        return credit;
    }
}

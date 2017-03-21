package domain;

public class Credit {
    private String bank;
    private Integer minSumm;
    private Integer maxSumm;
    private Float percent;
    private Integer period;
    private boolean closingBeforeTerm;
    private boolean increasingSumm;

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public Integer getMinSumm() {
        return minSumm;
    }

    public void setMinSumm(Integer minSumm) {
        this.minSumm = minSumm;
    }

    public Integer getMaxSumm() {
        return maxSumm;
    }

    public void setMaxSumm(Integer maxSumm) {
        this.maxSumm = maxSumm;
    }

    public Float getPercent() {
        return percent;
    }

    public void setPercent(Float percent) {
        this.percent = percent;
    }

    public Integer getPeriod() {
        return period;
    }

    public void setPeriod(Integer period) {
        this.period = period;
    }

    public boolean isClosingBeforeTerm() {
        return closingBeforeTerm;
    }

    public void setClosingBeforeTerm(boolean closingBeforeTerm) {
        this.closingBeforeTerm = closingBeforeTerm;
    }

    public boolean isIncreasingSumm() {
        return increasingSumm;
    }

    public void setIncreasingSumm(boolean increasingSumm) {
        this.increasingSumm = increasingSumm;
    }
}

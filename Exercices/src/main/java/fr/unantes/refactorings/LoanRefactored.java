package fr.unantes.refactorings;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LoanRefactored {

    private static String TERM_LOAN = "TL";
    private static String REVOLVER = "RC";
    private static String RCTL = "RCTL";
    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;


    private String type;
    private float notional;
    private float outstanding;
    private int customerRating;
    private Date maturity;
    private Date expiry;
    private double commitment;
    private List<Payment> payments;
    private Date today;
    private Date start;
    private int riskRating;

    public double capital() {
        return new CapitalStrategy().capital(this);
    }

    protected double outstandingRiskAmount() {
        return outstanding;
    }

    protected double unusedRiskAmount() {
        return (getCommitment() - outstanding);
    }

    public double duration() {
        if (getExpiry() == null && getMaturity() != null)
            return weightedAverageDuration();
        else if (getExpiry() != null && getMaturity() == null)
            return yearsTo(getExpiry());
        return 0.0;
    }

    private double weightedAverageDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = getPayments().iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date()) * payment.amount();
        }
        if (getCommitment() != 0.0)
            duration = weightedAverage / sumOfPayments;
        return duration;
    }

    private double yearsTo(Date endDate) {
        Date beginDate = (today == null ? start : today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }

    protected double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    protected double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }

    protected double getUnusedPercentage() {
        return 0.0;
    }

    protected Date getMaturity() {
        return maturity;
    }

    protected Date getExpiry() {
        return expiry;
    }

    protected double getCommitment() {
        return commitment;
    }

    protected List<Payment> getPayments() {
        return payments;
    }
}

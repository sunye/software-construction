package fr.unantes.refactorings;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Loan {

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
        if (expiry == null && maturity != null)
            return commitment * duration() * riskFactor();
        if (expiry != null && maturity == null) {
            if (getUnusedPercentage() != 1.0)
                return commitment * getUnusedPercentage() * duration() * riskFactor();
            else
                return (outstandingRiskAmount() * duration() * riskFactor())
                        + (unusedRiskAmount() * duration() * unusedRiskFactor());
        }
        return 0.0;
    }

    private double outstandingRiskAmount() {
        return outstanding;
    }

    private double unusedRiskAmount() {
        return (commitment - outstanding);
    }

    public double duration() {
        if (expiry == null && maturity != null)
            return weightedAverageDuration();
        else if (expiry != null && maturity == null)
            return yearsTo(expiry);
        return 0.0;
    }

    private double weightedAverageDuration() {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = payments.iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += yearsTo(payment.date()) * payment.amount();
        }
        if (commitment != 0.0)
            duration = weightedAverage / sumOfPayments;
        return duration;
    }

    private double yearsTo(Date endDate) {
        Date beginDate = (today == null ? start : today);
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }

    private double riskFactor() {
        return RiskFactor.getFactors().forRating(riskRating);
    }

    private double unusedRiskFactor() {
        return UnusedRiskFactors.getFactors().forRating(riskRating);
    }

    private double getUnusedPercentage() {
        return 0.0;
    }
}

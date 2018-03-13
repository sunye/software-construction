package fr.unantes.refactorings;

import java.util.Date;
import java.util.Iterator;

public class CapitalStrategy {
    private static final int DAYS_PER_YEAR = 365;
    private static final int MILLIS_PER_DAY = 86400000;

    public CapitalStrategy() {
    }

    public double capital(LoanRefactored loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return loan.getCommitment() * this.duration(loan) * this.riskFactor(loan);
        if (loan.getExpiry() != null && loan.getMaturity() == null) {
            if (loan.getUnusedPercentage() != 1.0)
                return loan.getCommitment() * loan.getUnusedPercentage() * this.duration(loan) * this.riskFactor(loan);
            else
                return (loan.outstandingRiskAmount() * this.duration(loan) * this.riskFactor(loan))
                        + (loan.unusedRiskAmount() * this.duration(loan) * this.unusedRiskFactor(loan));
        }
        return 0.0;
    }

    public double duration(LoanRefactored loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return this.weightedAverageDuration(loan);
        else if (loan.getExpiry() != null && loan.getMaturity() == null)
            return loan.strategy.yearsTo(loan.getExpiry(), loan);
        return 0.0;
    }

    protected double riskFactor(LoanRefactored loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    protected double unusedRiskFactor(LoanRefactored loan) {
        return UnusedRiskFactors.getFactors().forRating(loan.getRiskRating());
    }

    protected double weightedAverageDuration(LoanRefactored loan) {
        double duration = 0.0;
        double weightedAverage = 0.0;
        double sumOfPayments = 0.0;
        Iterator loanPayments = loan.getPayments().iterator();
        while (loanPayments.hasNext()) {
            Payment payment = (Payment) loanPayments.next();
            sumOfPayments += payment.amount();
            weightedAverage += loan.strategy.yearsTo(payment.date(), loan) * payment.amount();
        }
        if (loan.getCommitment() != 0.0)
            duration = weightedAverage / sumOfPayments;
        return duration;
    }

    protected double yearsTo(Date endDate, LoanRefactored loanRefactored) {
        Date beginDate = (loanRefactored.getToday() == null ? loanRefactored.getStart() : loanRefactored.getToday());
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}

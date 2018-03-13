package fr.unantes.refactorings;

import java.util.Date;

public abstract class CapitalStrategyRefactored {

    private static final int MILLIS_PER_DAY = 86400000;
    private static final int DAYS_PER_YEAR = 365;

    public abstract double capital(LoanRefactored loan);

    protected double riskFactorFor(LoanRefactored loan) {
        return RiskFactor.getFactors().forRating(loan.getRiskRating());
    }

    public double duration(LoanRefactored loan) {
        return yearsTo(loan.getExpiry(), loan);
    }

    protected double yearsTo(Date endDate, LoanRefactored loan) {
        Date beginDate = (loan.getToday() == null ? loan.getStart() : loan.getToday());
        return ((endDate.getTime() - beginDate.getTime()) / MILLIS_PER_DAY) / DAYS_PER_YEAR;
    }
}

package fr.unantes.refactorings;

import java.util.Date;
import java.util.List;

public class LoanRefactored {

    private static String TERM_LOAN = "TL";
    private static String REVOLVER = "RC";
    private static String RCTL = "RCTL";


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
    final CapitalStrategy strategy;

    public LoanRefactored() {
        strategy = new CapitalStrategy();
    }

    public double capital() {
        return strategy.capital(this);
    }

    protected double outstandingRiskAmount() {
        return outstanding;
    }

    protected double unusedRiskAmount() {
        return (getCommitment() - outstanding);
    }

    public double duration() {
        return strategy.duration(this);
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

    public int getRiskRating() {
        return riskRating;
    }

    protected Date getToday() {
        return today;
    }

    protected Date getStart() {
        return start;
    }
}

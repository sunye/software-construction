package fr.unantes.refactorings;

public class CapitalStrategy {
    public double capital(LoanRefactored loan) {
        if (loan.getExpiry() == null && loan.getMaturity() != null)
            return loan.getCommitment() * loan.duration() * loan.riskFactor();
        if (loan.getExpiry() != null && loan.getMaturity() == null) {
            if (loan.getUnusedPercentage() != 1.0)
                return loan.getCommitment() *loan.getUnusedPercentage() * loan.duration() * loan.riskFactor();
            else
                return (loan.outstandingRiskAmount() * loan.duration() * loan.riskFactor())
                        + (loan.unusedRiskAmount() * loan.duration() * loan.unusedRiskFactor());
        }
        return 0.0;
    }
}

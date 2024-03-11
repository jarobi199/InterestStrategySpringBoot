package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.repository.InterestRepository;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculationStrategyFactory {

    private final InterestCalculationStrategy currentAccountInterestCalculationStrategy;
    private final InterestCalculationStrategy savingsAccountInterestCalculationStrategy;
    private final InterestCalculationStrategy moneyMarketAccountInterestCalculationStrategy;
    private final InterestCalculationStrategy highRollerMoneyMarketAccountInterestCalculationStrategy;
    private final InterestCalculationStrategy noInterestCalculationStrategy;

    public InterestCalculationStrategyFactory(InterestRepository interestRepository) {
        this.currentAccountInterestCalculationStrategy = new CurrentAccountInterestCalculation(interestRepository);
        this.savingsAccountInterestCalculationStrategy = new SavingsAccountInterestCalculation(interestRepository);
        this.moneyMarketAccountInterestCalculationStrategy = new MoneyMarketInterestCalculation(interestRepository);
        this.highRollerMoneyMarketAccountInterestCalculationStrategy = new HighRollerMoneyMarketInterestCalculation(interestRepository);
        this.noInterestCalculationStrategy = new NoInterestCalculation();
    }

    public InterestCalculationStrategy getInterestCalculationStrategy(AccountTypes accountType) {
        return switch (accountType) {
            case CURRENT -> currentAccountInterestCalculationStrategy;
            case SAVINGS -> savingsAccountInterestCalculationStrategy;
            case STANDARD_MONEY_MARKET -> moneyMarketAccountInterestCalculationStrategy;
            case HIGH_ROLLER_MONEY_MARKET -> highRollerMoneyMarketAccountInterestCalculationStrategy;
            default -> noInterestCalculationStrategy;
        };
    }

}

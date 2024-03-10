package io.interest.strategy;

import io.interest.AccountTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class InterestCalculationStrategyFactory {

    @Autowired
    @Qualifier("currentAccountInterestCalculation")
    private InterestCalculationStrategy currentAccountInterestCalculationStrategy;

    @Autowired
    @Qualifier("savingsAccountInterestCalculation")
    private InterestCalculationStrategy savingsAccountInterestCalculationStrategy;

    @Autowired
    @Qualifier("moneyMarketInterestCalculation")
    private InterestCalculationStrategy moneyMarketAccountInterestCalculationStrategy;

    @Autowired
    @Qualifier("highRollerMoneyMarketInterestCalculation")
    private InterestCalculationStrategy highRollerMoneyMarketAccountInterestCalculationStrategy;

    @Autowired
    @Qualifier("noInterestCalculation")
    private InterestCalculationStrategy noInterestCalculationStrategy;

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

package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.repository.InterestRepository;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InterestCalculationStrategyFactory {

    private final Map<AccountTypes, InterestCalculationStrategy> strategyMap;

    public InterestCalculationStrategyFactory(InterestRepository interestRepository) {
        this.strategyMap = new HashMap<>();
        strategyMap.put(AccountTypes.CURRENT, new CurrentAccountInterestCalculation(interestRepository));
        strategyMap.put(AccountTypes.SAVINGS, new CurrentAccountInterestCalculation(interestRepository));
        strategyMap.put(AccountTypes.STANDARD_MONEY_MARKET, new CurrentAccountInterestCalculation(interestRepository));
        strategyMap.put(AccountTypes.HIGH_ROLLER_MONEY_MARKET, new CurrentAccountInterestCalculation(interestRepository));
    }

    public InterestCalculationStrategy getInterestCalculationStrategy(AccountTypes accountType) {
        InterestCalculationStrategy strategy = strategyMap.get(accountType);
        if(strategy == null) {
            strategy = new NoInterestCalculation();
        }

        return strategy;
    }

}

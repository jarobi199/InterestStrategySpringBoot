package io.interest.service;

import io.interest.AccountTypes;
import io.interest.strategy.InterestCalculationStrategy;
import io.interest.strategy.InterestCalculationStrategyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService {

    @Autowired
    InterestCalculationStrategyFactory interestCalculationStrategyFactory;

    public String displayService(AccountTypes type, double balance) {
        InterestCalculationStrategy strategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(type);
        double interest = strategy.calculateInterest(balance);

        return  "BANKING DETAILS" + "\n" +
                "================" + "\n" +
                "Account Type: " + type + "\n" +
                "Balance: $" + balance + "\n" +
                "Interest: $" + interest;
    }
}

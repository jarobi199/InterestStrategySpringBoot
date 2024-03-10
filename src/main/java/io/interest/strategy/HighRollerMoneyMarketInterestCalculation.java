package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("highRollerMoneyMarketInterestCalculation")
public class HighRollerMoneyMarketInterestCalculation implements InterestCalculationStrategy {

    @Autowired
    InterestRepository interestRepository;

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interestRate = interestRepository.findByType(AccountTypes.HIGH_ROLLER_MONEY_MARKET.name());
        return accountBalance < 100000.00 ? 0 : accountBalance * (interestRate.getRate() / 12);
    }

}
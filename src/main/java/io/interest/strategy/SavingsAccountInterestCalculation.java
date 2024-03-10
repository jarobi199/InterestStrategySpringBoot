package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("savingsAccountInterestCalculation")
public class SavingsAccountInterestCalculation implements InterestCalculationStrategy {

    @Autowired
    InterestRepository interestRepository;

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interest = interestRepository.findByType(AccountTypes.SAVINGS.name());
        return accountBalance * (interest.getRate() / 12);
    }

}

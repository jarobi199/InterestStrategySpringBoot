package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("currentAccountInterestCalculation")
public class CurrentAccountInterestCalculation implements InterestCalculationStrategy {

    @Autowired
    InterestRepository interestRepository;

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interest = interestRepository.findByType(AccountTypes.CURRENT.name());
        return accountBalance * (interest.getRate() / 12);
    }

}
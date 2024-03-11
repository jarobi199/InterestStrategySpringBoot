package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;
import org.springframework.stereotype.Component;

@Component("savingsAccountInterestCalculation")
public class SavingsAccountInterestCalculation implements InterestCalculationStrategy {

    private final InterestRepository interestRepository;

    public SavingsAccountInterestCalculation(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interest = interestRepository.findByType(AccountTypes.SAVINGS.name());
        return accountBalance * (interest.getRate() / 12);
    }

}

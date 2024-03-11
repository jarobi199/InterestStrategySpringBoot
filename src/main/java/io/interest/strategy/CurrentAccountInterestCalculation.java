package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;

public class CurrentAccountInterestCalculation implements InterestCalculationStrategy {

    private final InterestRepository interestRepository;

    public CurrentAccountInterestCalculation(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interest = interestRepository.findByType(AccountTypes.CURRENT.name());
        return accountBalance * (interest.getRate() / 12);
    }

}
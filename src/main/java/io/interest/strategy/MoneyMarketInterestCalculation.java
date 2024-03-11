package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;

public class MoneyMarketInterestCalculation implements InterestCalculationStrategy {

    private final InterestRepository interestRepository;

    public MoneyMarketInterestCalculation(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interest = interestRepository.findByType(AccountTypes.STANDARD_MONEY_MARKET.name());
        return accountBalance * (interest.getRate() / 12);
    }

}
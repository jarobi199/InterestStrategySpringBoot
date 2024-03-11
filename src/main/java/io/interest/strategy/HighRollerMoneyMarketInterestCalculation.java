package io.interest.strategy;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;

public class HighRollerMoneyMarketInterestCalculation implements InterestCalculationStrategy {

    private final InterestRepository interestRepository;

    public HighRollerMoneyMarketInterestCalculation(InterestRepository interestRepository) {
        this.interestRepository = interestRepository;
    }

    @Override
    public double calculateInterest(double accountBalance) {
        Interest interestRate = interestRepository.findByType(AccountTypes.HIGH_ROLLER_MONEY_MARKET.name());
        return accountBalance < 100000.00 ? 0 : accountBalance * (interestRate.getRate() / 12);
    }

}
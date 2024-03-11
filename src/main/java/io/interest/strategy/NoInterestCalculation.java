package io.interest.strategy;

public class NoInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return 0;
    }

}
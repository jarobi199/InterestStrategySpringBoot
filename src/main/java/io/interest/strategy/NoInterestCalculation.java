package io.interest.strategy;

import org.springframework.stereotype.Component;

@Component("noInterestCalculation")
public class NoInterestCalculation implements InterestCalculationStrategy {

    @Override
    public double calculateInterest(double accountBalance) {
        return 0;
    }

}
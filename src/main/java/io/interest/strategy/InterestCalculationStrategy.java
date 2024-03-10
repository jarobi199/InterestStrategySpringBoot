package io.interest.strategy;

import io.interest.model.Interest;

public interface InterestCalculationStrategy {
    double calculateInterest(double accountBalance);
}
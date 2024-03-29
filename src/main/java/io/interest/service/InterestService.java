package io.interest.service;

import io.interest.AccountTypes;
import io.interest.model.Interest;
import io.interest.repository.InterestRepository;
import io.interest.strategy.InterestCalculationStrategy;
import io.interest.strategy.InterestCalculationStrategyFactory;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InterestService {

    @Autowired
    private InterestRepository interestRepository;

    private InterestCalculationStrategyFactory interestCalculationStrategyFactory;

    public String displayService(AccountTypes type, double balance) {
        InterestCalculationStrategy strategy = interestCalculationStrategyFactory.getInterestCalculationStrategy(type);
        double interest = strategy.calculateInterest(balance);

        return  "BANKING DETAILS" + "\n" +
                "================" + "\n" +
                "Account Type: " + type + "\n" +
                "Balance: $" + balance + "\n" +
                "Interest: $" + interest;
    }

    public String postRate(AccountTypes type, double rate) {
        Interest interest = interestRepository.findByType(type.name());
        interest.setRate(rate);
        interestRepository.save(interest);

        return  "RATE UPDATE:" + "\n" +
                "================" + "\n" +
                "Account Type: " + type + "\n" +
                "Rate: " + interest.getRate() + "\n";

    }

    @PostConstruct
    private void  initializeFactory() {
        this.interestCalculationStrategyFactory = new InterestCalculationStrategyFactory(interestRepository);
    }
}

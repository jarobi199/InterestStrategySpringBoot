package io.interest.controller;

import io.interest.AccountTypes;
import io.interest.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InterestCalculatorController {

    @Autowired
    private InterestService interestService;

    @GetMapping("/interest")
    public ResponseEntity<String> getInterest(@RequestParam AccountTypes type, @RequestParam double balance) {
        String response = interestService.displayService(type, balance);
        return ResponseEntity.ok(response);
    }

}

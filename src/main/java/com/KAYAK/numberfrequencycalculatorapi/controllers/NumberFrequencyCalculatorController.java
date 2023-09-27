package com.KAYAK.numberfrequencycalculatorapi.controllers;

import com.KAYAK.numberfrequencycalculatorapi.dtos.NumberFrequencyCalculatorInputDto;
import com.KAYAK.numberfrequencycalculatorapi.services.NumberFrequencyCalculatorService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.KAYAK.numberfrequencycalculatorapi.NumberFrequencyCalculatorApiApplication.BASE_URL;

@CrossOrigin
@RestController
@RequestMapping(value = BASE_URL + "/numberFrequencyCalculator")
public class NumberFrequencyCalculatorController {

    @Autowired
    NumberFrequencyCalculatorService numberFrequencyCalculatorService;

    @PostMapping()
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> calculateNumberFrequency(@RequestBody @Valid NumberFrequencyCalculatorInputDto input) {
        numberFrequencyCalculatorService.calculateNumberFrequency(input.getData());
        return ResponseEntity.ok("Successful, check the API console!");
    }
}
